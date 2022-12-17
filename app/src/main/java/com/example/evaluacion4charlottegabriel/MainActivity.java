package com.example.evaluacion4charlottegabriel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluacion4charlottegabriel.Dao.Carta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarActividadSiyno(View view) {
        Bundle bundle = new Bundle();

        // Generar un numero y agregarlo al bundle
        int numero = (int) (Math.random() * 78);
        bundle.putInt("numero", numero);

        Intent i = new Intent(this, SiYNo.class);

        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        referencia.child(String.valueOf(numero)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Leer informacion de la carta y agregarla al bundle
                Carta carta = snapshot.getValue(Carta.class);
                bundle.putSerializable("carta", carta);

                // Agregar los extras al intent e iniciar la actividad
                i.putExtras(bundle);
                startActivity(i);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    public void inciarActividadCartaDelDia(View view) {
        Intent i = new Intent(this, CartaDelDia.class);

        startActivity(i);
    }

}