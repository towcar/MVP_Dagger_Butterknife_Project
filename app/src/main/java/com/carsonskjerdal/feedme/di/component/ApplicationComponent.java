package com.carsonskjerdal.feedme.di.component;

import android.app.Application;
import android.content.Context;

import com.carsonskjerdal.feedme.FeedMe;
import com.carsonskjerdal.feedme.data.DataManager;
import com.carsonskjerdal.feedme.di.ApplicationContext;
import com.carsonskjerdal.feedme.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

   void inject(FeedMe app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
