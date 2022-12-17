package com.example.evaluacion4charlottegabriel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evaluacion4charlottegabriel.Dao.Carta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class SiYNo extends AppCompatActivity {
    private TextView tvtitulo;
    private TextView tvdescripcion;
    private TextView tvresultado;
    private ImageView ivcarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_yno);
        tvtitulo = findViewById(R.id.Siynotitulocarta);
        tvdescripcion = findViewById(R.id.Siynodescripcion);
        tvresultado = findViewById(R.id.Siynoresultado);
        ivcarta = findViewById(R.id.Siynoimagencarta);
        SiNoQuizas();
    }

    private void SiNoQuizas() {
        int numero = (int) (Math.random() * 78);
        Integer[] si = {
                0, 1, 3, 6, 7,
                8, 10, 14, 17, 19,
                20, 21, 22, 23, 24,
                25, 27, 29, 30, 32,
                33, 34, 35, 36, 37,
                38, 41, 44, 45, 46,
                47, 48, 49, 50, 60,
                61, 64, 66, 69, 71,
                72, 73, 74, 75, 76,
                77
        };
        Integer[] no = {
                13, 15, 16, 18, 26,
                28, 31, 40, 43, 52,
                54, 56, 57, 58, 59,
                67, 68
        };

        if (Arrays.asList(si).contains(numero)) {
            tvresultado.setText("Tu respuesta es si₍ᐢ. ̫ .ᐢ₎");
        } else if (Arrays.asList(no).contains(numero)) {
            tvresultado.setText("Tu respuesta es no lo siento(ó﹏ò｡)");
        } else {
            tvresultado.setText("(ง ˃ ³ ˂)ว ⁼³₌₃⁼³ Tu respuesta es talves");

        }

        String nombreCarta = String.format("carta%d", numero);
        int valorimagencarta = getResources().getIdentifier(nombreCarta, "drawable", getPackageName());
        ivcarta.setImageResource(valorimagencarta);

        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        referencia.child(String.valueOf(numero)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Carta carta =  snapshot.getValue(Carta.class);
                tvtitulo.setText(carta.getTitulo());
                tvdescripcion.setText(carta.getDescripcion());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}