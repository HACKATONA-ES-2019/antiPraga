package com.hackatona.epidemia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListAdapter;
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
     List<String> sintomasConfirmados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoSintoma = findViewById(R.id.sintomaCampo);


        requestService.retornarSintomas(new RequestService.BookmarkCallback() {
            @Override
            public void onSuccess(List<Sintoma> list) {

                listaSintomas.addAll(list);
                String[] listaSintomasNome = new String[list.size()];

                for(int i = 0; i < list.size(); i++){
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
                if(campoSintoma.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "Digite algo!", Toast.LENGTH_LONG).show();
                } else {
                    for(int i = 0; i < listaSintomas.size(); i++){
                        if(campoSintoma.getText().toString().equalsIgnoreCase(listaSintomas.get(i).getNome())){

                        }
                    }
                }
            }
        });

    }



    private void setarSintomas(List<Sintoma> list) {
                campoSintoma.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));


    }




}
