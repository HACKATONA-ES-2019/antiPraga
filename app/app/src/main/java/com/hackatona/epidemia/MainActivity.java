package com.hackatona.epidemia;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hackatona.epidemia.entity.Sintoma;
import com.hackatona.epidemia.web.RequestService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Sintoma> listaSintomas = new ArrayList<>();
    RequestService requestService = new RequestService();
    AutoCompleteTextView campoSintoma;
    List<Sintoma> sintomasConfirmados = new ArrayList<>();
    TextView sintomasCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoSintoma = findViewById(R.id.sintomaCampo);
        sintomasCadastrados = findViewById(R.id.sintomasCadastrados);
        sintomasCadastrados.setText("");


        requestService.retornarSintomas(new RequestService.BookmarkCallback() {
            @Override
            public void onSuccess(List<Sintoma> list) {

                listaSintomas.addAll(list);
                String[] listaSintomasNome = new String[list.size()];

                for (int i = 0; i < list.size(); i++) {
                    listaSintomasNome[i] = list.get(i).getNome();
                }

                campoSintoma.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listaSintomasNome));

            }

            @Override
            public void onError() {

            }
        });


        Button botaoAdd = findViewById(R.id.botaoAdd);
        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (campoSintoma.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Digite algo!", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < listaSintomas.size(); i++) {
                        if (campoSintoma.getText().toString().equalsIgnoreCase(listaSintomas.get(i).getNome())) {
                            sintomasConfirmados.add(new Sintoma(listaSintomas.get(i).getNome(), listaSintomas.get(i).getIdSintoma()));
                            sintomasCadastrados.setText(sintomasCadastrados.getText().toString() + listaSintomas.get(i).getNome() + '\n');
                            campoSintoma.setText("");
                        }
                    }
                }
                System.out.println(sintomasConfirmados);
            }
        });

        Button botaoPronto = findViewById(R.id.botaoPronto);
        botaoPronto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                requestService.enviarSintomas(new RequestService.BookmarkCallback() {
                    @Override
                    public void onSuccess(List<Sintoma> list) {

                    }

                    @Override
                    public void onError() {

                    }
                }, sintomasConfirmados);


            }
            });


        /*        LocationManager locManager;
                locManager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
                locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L,
                        500.0f, locationListener);
                Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                }
                System.out.println();
            }
        });*/

    }



    private void setarSintomas(List<Sintoma> list) {
                campoSintoma.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));


    }




}
