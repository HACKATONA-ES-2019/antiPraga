package com.hackatona.doencas.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.hackatona.doencas.util.Constants.*;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public APIRequester getServiceRequester() {
        return this.retrofit.create(APIRequester.class);
    }

}
