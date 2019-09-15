package com.hackatona.epidemia.web;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.hackatona.epidemia.util.Constants.*;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public APIServices getServices() {
        return this.retrofit.create(APIServices.class);
    }

}
