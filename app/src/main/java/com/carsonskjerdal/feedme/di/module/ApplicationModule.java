package com.carsonskjerdal.feedme.di.module;

import android.app.Application;
import android.content.Context;

import com.carsonskjerdal.feedme.data.AppDataManager;
import com.carsonskjerdal.feedme.data.DataManager;
import com.carsonskjerdal.feedme.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

}