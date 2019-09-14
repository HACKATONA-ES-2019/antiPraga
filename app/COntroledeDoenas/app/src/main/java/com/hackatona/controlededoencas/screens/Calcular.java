package com.hackatona.controlededoencas.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hackatona.controlededoencas.R;

public class Calcular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        Button botao = findViewById(R.id.botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText valor1 = findViewById(R.id.valor1);
                EditText valor2 = findViewById(R.id.valor2);

                TextView resultado = findViewById(R.id.resultado);

                int valorUm = Integer.parseInt(String.valueOf(valor1.getText()));
                int valorDois =  Integer.parseInt(String.valueOf(valor2.getText()));
                int resultadoSoma = valorUm + valorDois;
                resultado.setText(String.valueOf(resultadoSoma));

            }
        });


    }
}
