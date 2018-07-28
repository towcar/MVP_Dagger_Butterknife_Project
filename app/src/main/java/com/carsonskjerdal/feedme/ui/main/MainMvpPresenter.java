package com.carsonskjerdal.feedme.ui.main;

import com.carsonskjerdal.feedme.di.PerActivity;
import com.carsonskjerdal.feedme.ui.base.MvpPresenter;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onRandomButtonClicked();
}