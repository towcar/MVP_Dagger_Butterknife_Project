package com.carsonskjerdal.feedme.ui.base;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
}
