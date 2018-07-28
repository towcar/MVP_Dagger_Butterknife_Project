package com.carsonskjerdal.feedme;

import android.app.Application;

import com.carsonskjerdal.feedme.data.DataManager;
import com.carsonskjerdal.feedme.di.component.ApplicationComponent;
import com.carsonskjerdal.feedme.di.component.DaggerApplicationComponent;
import com.carsonskjerdal.feedme.di.module.ApplicationModule;

import java.util.logging.Level;

import javax.inject.Inject;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public class FeedMe extends Application {

    @Inject
    DataManager mDataManager;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        //AppLogger.init();

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
