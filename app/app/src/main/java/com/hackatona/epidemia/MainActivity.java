package com.hackatona.epidemia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hackatona.epidemia.entity.Sintoma;
import com.hackatona.epidemia.web.APIServices;
import com.hackatona.epidemia.web.RequestService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestService requestService = new RequestService();

        requestService.startService(new RequestService.BookmarkCallback() {
            @Override
            public void onSuccess(List<Sintoma> list) {

            }

            @Override
            public void onError() {

            }
        }, "dor");

    }
}
