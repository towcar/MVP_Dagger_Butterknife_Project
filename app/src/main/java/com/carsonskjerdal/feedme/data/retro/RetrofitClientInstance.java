package com.carsonskjerdal.feedme.data.retro;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carson on 6/28/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL2 = "https://icanhazdadjoke.com";
    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
