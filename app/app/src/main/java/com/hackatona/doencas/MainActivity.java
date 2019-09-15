package com.hackatona.doencas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hackatona.doencas.entity.Sintoma;
import com.hackatona.doencas.util.APIServices;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final List<Sintoma> sintomaLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        APIServices apiServices = new APIServices();

        System.out.println("caiu aqui 1");

        apiServices.requestSintomas(new APIServices.BookmarkCallbackStatus() {
            @Override
            public void onSuccess(List<Sintoma> sintomas) {
                sintomaLista.addAll(sintomas);
                listaSintomas(sintomaLista);
            }

            @Override
            public void onError() {
                System.out.println("caiu aqui no erro");
            }
        }, "porra é o cu da cachorra");

    }

    private void listaSintomas(List<Sintoma> sintomaLista) {
        System.out.println("teste" + sintomaLista);

    }

}
