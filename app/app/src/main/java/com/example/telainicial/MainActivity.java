package com.example.telainicial;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <String> listaSintomas = new ArrayList <String>();
    String texto = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                TextView textView4 = findViewById(R.id.textView4);

                listaSintomas.add(String.valueOf(editText.getText()));
                texto += editText.getText() + " ,";
                textView4.setText(texto);

            }
        });
    }
}
