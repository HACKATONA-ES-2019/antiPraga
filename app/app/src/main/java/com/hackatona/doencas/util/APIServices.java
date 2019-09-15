package com.hackatona.doencas.util;

import com.hackatona.doencas.entity.Sintoma;
import com.hackatona.doencas.retrofit.RetrofitConfig;

import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class APIServices {

    public interface BookmarkCallbackStatus {
        void onSuccess(List<Sintoma> sintomas);

        void onError();
    }

    /**
     * This method requests to the server
     * start the count service
     */

    public void requestSintomas(final BookmarkCallbackStatus callback, String sintoma) {

        Call<List<Sintoma>> call = new RetrofitConfig().getServiceRequester().requestSintomas(sintoma);
       HttpUrl teste =  new RetrofitConfig().getServiceRequester().requestSintomas(sintoma).request().url();
        call.enqueue(new Callback<List<Sintoma>>() {
            @Override
            public void onResponse(Call<List<Sintoma>> call, Response<List<Sintoma>> response) {

                List<Sintoma> listaSintomas = new ArrayList<>();
                Sintoma sintoma = null;

                if (!response.isSuccessful()) {

                    callback.onError();

                } else {

                    for (Sintoma size : response.body()) {

                        if(size.getNome() != null){

                           sintoma = new Sintoma(size.getNome());

                        }


                        listaSintomas.add(sintoma);

                    }

                    callback.onSuccess(listaSintomas);

                }
            }

            @Override
            public void onFailure(Call<List<Sintoma>> call, Throwable t) {
                System.out.println("ERRRO////:" + t);
                System.out.println("caiu aqui no erro");
                callback.onError();

            }
        });
    }

}
