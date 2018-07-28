package com.carsonskjerdal.feedme.di.component;

import com.carsonskjerdal.feedme.di.PerActivity;
import com.carsonskjerdal.feedme.di.module.ActivityModule;
import com.carsonskjerdal.feedme.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
