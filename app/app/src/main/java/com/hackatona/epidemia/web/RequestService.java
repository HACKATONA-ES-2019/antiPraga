package com.hackatona.epidemia.web;

import com.hackatona.epidemia.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestService {

    public interface BookmarkCallback {
        void onSuccess(List<Sintoma> list);

        void onError();
    }

    public void startService(final BookmarkCallback callback, String sintoma) {

        Call<List<Sintoma>> call = new RetrofitConfig().getServices().requestSintoma(sintoma);
        call.enqueue(new Callback<List<Sintoma>>() {
            @Override
            public void onResponse(Call<List<Sintoma>> call, Response<List<Sintoma>> response) {
                List<Sintoma> list = new ArrayList<>();
                Sintoma sintoma;
                if (!response.isSuccessful()) {
                    callback.onError();
                } else {

                    for (Sintoma size : response.body()) {

                        sintoma = new Sintoma(size.getNome());

                        list.add(sintoma);

                    }
                    callback.onSuccess(list);
                }
            }

            @Override
            public void onFailure(Call<List<Sintoma>> call, Throwable t) {
                callback.onError();
            }
        });
    }


}
