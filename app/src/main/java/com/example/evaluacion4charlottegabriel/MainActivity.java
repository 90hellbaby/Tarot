package com.example.evaluacion4charlottegabriel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void iniciarActividadSiyno(View view){
        Intent i = new Intent( this, SiYNo.class);
        startActivity(i);
    }

    public  void inciarActividadCartaDelDia(View view){
        Intent i = new Intent( this, CartaDelDia.class);

        startActivity(i);
    }

}