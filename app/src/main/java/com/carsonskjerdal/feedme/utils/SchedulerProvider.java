package com.carsonskjerdal.feedme.utils;

import io.reactivex.Scheduler;

/**
 * Created by Carson on 7/3/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}