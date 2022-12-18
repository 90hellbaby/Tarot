package com.example.evaluacion4charlottegabriel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evaluacion4charlottegabriel.Dao.Carta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tarotPareja extends AppCompatActivity {
    private TextView tvtitulotu;
    private TextView tvtitulotupareja;
    private  TextView tvdescriciontu;
    private  TextView tvdescripciontupareja;
    private  ImageView ivcartatupareja;
    private ImageView ivcartatu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarot_pareja);
        tvdescriciontu = findViewById(R.id.tarotParejaTudescripcion);
        tvdescripciontupareja = findViewById(R.id.tarotTuparejadesripccion);
        tvtitulotu = findViewById(R.id.tarotParejaTutitulocarta);
        tvtitulotupareja = findViewById(R.id.tarotTuParejatitulocarta);
        ivcartatupareja = findViewById(R.id.tarotTuparejaImagen);
        ivcartatu = findViewById(R.id.tarotParejaTuImagen);
        tarotPareja();
    }
    private void tarotPareja(){
        int numerotupersona = (int) (Math.random() * 78);
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
        String nombreCarta = String.format("carta%d", numero);
        String nombreCartatupersona = String.format("carta%d", numerotupersona);
        int valorimagencarta = getResources().getIdentifier(nombreCarta, "drawable", getPackageName());
        int valorimagencartatupersona = getResources().getIdentifier(nombreCartatupersona, "drawable", getPackageName());
        ivcartatu.setImageResource(valorimagencarta);
        ivcartatupareja.setImageResource(valorimagencartatupersona);

        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        referencia.child(String.valueOf(numero)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Carta carta =  snapshot.getValue(Carta.class);
                tvtitulotu.setText(carta.getTitulo());
                tvtitulotupareja.setText(carta.getTitulo());
                tvdescriciontu.setText(carta.getDescripcion());
                tvdescripciontupareja.setText(carta.getDescripcion());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}