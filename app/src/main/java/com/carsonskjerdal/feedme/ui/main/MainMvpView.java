package com.carsonskjerdal.feedme.ui.main;

import com.carsonskjerdal.feedme.ui.base.MvpView;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public interface MainMvpView extends MvpView {


    void updateTextView(String testVariable);

    void showLoading();
}