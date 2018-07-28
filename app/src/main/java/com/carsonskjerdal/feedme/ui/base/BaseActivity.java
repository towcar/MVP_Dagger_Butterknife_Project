package com.carsonskjerdal.feedme.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.carsonskjerdal.feedme.FeedMe;
import com.carsonskjerdal.feedme.di.component.ActivityComponent;
import com.carsonskjerdal.feedme.di.component.DaggerActivityComponent;
import com.carsonskjerdal.feedme.di.module.ActivityModule;
//import com.carsonskjerdal.feedme.di.component.DaggerActivityComponent;

import butterknife.Unbinder;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public abstract class BaseActivity extends AppCompatActivity
        implements MvpView {

    private ActivityComponent mActivityComponent;

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((FeedMe) getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();
}
