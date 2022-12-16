package com.example.evaluacion4charlottegabriel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDateTime;

public class CartaDelDia extends AppCompatActivity {
    TextView tvTitulo;
    TextView tvDescripcion;
    ImageView ivImagen;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_del_dia);
        tvTitulo = findViewById(R.id.CartaDelDiaTitulo);
        tvDescripcion = findViewById(R.id.CartaDelDiaDescripcion);
        ivImagen = findViewById(R.id.CartaDelDiaImagen);
        cartaDelDia();
    }
    private  void cartaDelDia(){
        LocalDateTime fecha = LocalDateTime.now();
        int mes = fecha.getMonthValue();
        int dia = fecha.getDayOfMonth();
        int año = fecha.getYear();
        int numero = dia+mes+año;
        numero = numero%78;

        String nombreCarta = String.format("carta%d", numero);
        int valorimagencarta = getResources().getIdentifier(nombreCarta, "drawable", getPackageName());
        ivImagen.setImageResource(valorimagencarta);

    }


}