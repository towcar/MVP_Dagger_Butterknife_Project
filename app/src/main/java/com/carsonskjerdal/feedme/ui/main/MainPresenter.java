package com.carsonskjerdal.feedme.ui.main;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.util.Log;

import com.carsonskjerdal.feedme.data.DataManager;
import com.carsonskjerdal.feedme.data.retro.GetDataService;
import com.carsonskjerdal.feedme.data.retro.RetrofitClientInstance;
import com.carsonskjerdal.feedme.data.retro.model.Recipe;
import com.carsonskjerdal.feedme.data.retro.model.RecipeList;
import com.carsonskjerdal.feedme.ui.base.BasePresenter;
import com.carsonskjerdal.feedme.utils.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */

//where the action take place of the Main Activity, don't update UI here I believe
public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";
    String title = "";
    private Retrofit retrofit;

    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    private void handleError(Throwable t){
        Log.e("Observer", "");

    }


    //single api call using retrofit and rxjava
    @SuppressLint("CheckResult")
    private void getDrinkData(){

        retrofit = RetrofitClientInstance.getRetrofitInstance();

        retrofit.create(GetDataService.class).getRecipe()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError );
    }

    private void handleResults(RecipeList recipeList) {
        int i = recipeList.getDrinks().size();
        Log.e(TAG, "size is: "+ i);
        Recipe recipe = recipeList.getDrinks().get(0);
        getMvpView().updateTextView(recipe.getStrDrink());
    }

    @Override
    public void onRandomButtonClicked() {

        getDrinkData();
        /*
        getCompositeDisposable().add(getDataManager().getRecipeName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError ));

        getMvpView().showLoading();
        Log.e(TAG, "Random Method Open");
        getCompositeDisposable().add(getDataManager()
                .getRecipeName()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                               @Override
                               public void onNext(String s) {
                                   title = s;

                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {
                                   getMvpView().updateTextView(title);
                               }


                           }));


                        //getMvpView().updateTextView(title);
                        //Log.e(TAG, "end method");


//getMvpView().updateTextView(s);

                        //needs to pull data from website to display it
                        //String testVariable = getDataManager().getRecipeName();

                        //Log.e(TAG, testVariable);
                        //getmvp

                        //getMvpView().updateTextView(title);*/

    }

}
