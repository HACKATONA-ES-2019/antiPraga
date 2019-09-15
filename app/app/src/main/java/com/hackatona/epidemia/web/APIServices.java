package com.hackatona.epidemia.web;

import com.hackatona.epidemia.entity.Sintoma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.hackatona.epidemia.util.Constants.*;

public interface APIServices {


        @GET(REQUEST_SINTOMA)
        Call<List<Sintoma>> requestSintoma(@Query("sintoma") String sintoma);


}
