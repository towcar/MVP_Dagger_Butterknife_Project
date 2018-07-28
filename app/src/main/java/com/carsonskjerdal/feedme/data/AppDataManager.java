package com.carsonskjerdal.feedme.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.carsonskjerdal.feedme.data.retro.GetDataService;
import com.carsonskjerdal.feedme.data.retro.RetrofitClientInstance;
import com.carsonskjerdal.feedme.data.retro.model.Recipe;
import com.carsonskjerdal.feedme.data.retro.model.RecipeList;
import com.carsonskjerdal.feedme.di.ApplicationContext;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carson on 6/26/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;
    private String jokeText = "";
    Recipe recipe;

    @Inject
    public AppDataManager(@ApplicationContext Context context) {
        mContext = context;

    }

    @Override
    public void getRecipeName() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        recipe = retrofit.create(Recipe.class);


        /*Create handle for the RetrofitInstance interface*//*
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<RecipeList> call = service.getRecipe();
        call.enqueue(new Callback<RecipeList>() {
            @Override
            public void onResponse(@NonNull Call<RecipeList> call, @NonNull retrofit2.Response<RecipeList> response) {
                //generateDataList(response.body());

                Log.e("onResponse","Recipe is Successful = " + response.isSuccessful());
                //if response is false then skip to avoid null object reference
                if (response.isSuccessful()) {

                    RecipeList drinkRecipe = response.body();

                    List<Recipe> recipes = drinkRecipe.getDrinks();
                    jokeText = String.valueOf(recipes.size());
                    Recipe myRecipe = recipes.get(0);
                    jokeText = myRecipe.getStrDrink();

                    Log.e("On Response", "Result2: " + jokeText);
                }
                //jokeText = "null";

            }

            @Override
            public void onFailure(Call<RecipeList> call, Throwable t) {
                Log.e("On Response","Failure");
            }
        });

        //return jokeText;
*/
    }


}
