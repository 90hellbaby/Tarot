package com.example.evaluacion4charlottegabriel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evaluacion4charlottegabriel.Dao.Carta;

public class CartaDelDia extends AppCompatActivity {
    ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_del_dia);

        // Vincular los elementos de la vista
        TextView tvTitulo = findViewById(R.id.CartaDelDiaTitulo);
        TextView tvDescripcion = findViewById(R.id.CartaDelDiaDescripcion);
        ivImagen = findViewById(R.id.CartaDelDiaImagen);

        // Obtener los extras del intent
        Bundle bundle = getIntent().getExtras();
        int numero = bundle.getInt("numero");
        int rotacion = bundle.getInt("rotacion");
        Carta carta = (Carta) bundle.getSerializable("carta");

        // Mostrar la informacion de la carta
        if (rotacion == 0) {
            tvDescripcion.setText(carta.getDescripcion());
            tvTitulo.setText(carta.getTitulo());
        } else {
            tvDescripcion.setText("La carta esta invertida");
            tvTitulo.setText(carta.getTitulo() + " invertida");
        }

        // Mostrar imagen
        cartaDelDia(numero, rotacion);
    }

    private void cartaDelDia(int numero, int rotacion) {
        String nombreCarta = String.format("carta%d", numero);
        int valorimagencarta = getResources().getIdentifier(nombreCarta, "drawable", getPackageName());
        ivImagen.setImageResource(valorimagencarta);
        ivImagen.setRotation(rotacion);
    }
}