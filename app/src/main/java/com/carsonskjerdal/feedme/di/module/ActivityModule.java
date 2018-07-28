package com.carsonskjerdal.feedme.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.carsonskjerdal.feedme.di.ActivityContext;
import com.carsonskjerdal.feedme.di.PerActivity;
import com.carsonskjerdal.feedme.ui.main.MainMvpPresenter;
import com.carsonskjerdal.feedme.ui.main.MainMvpView;
import com.carsonskjerdal.feedme.ui.main.MainPresenter;
import com.carsonskjerdal.feedme.utils.AppSchedulerProvider;
import com.carsonskjerdal.feedme.utils.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }


}
