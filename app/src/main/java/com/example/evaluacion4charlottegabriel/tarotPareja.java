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

        Bundle bundle = getIntent().getExtras();
        int numero = bundle.getInt("numero");
        int numerotupersona = bundle.getInt("numerotupersona");
        tarotPareja(numero , numerotupersona);
        Carta tu = (Carta)bundle.getSerializable("tu");
        Carta pareja = (Carta)bundle.getSerializable("pareja");
        tvtitulotupareja.setText(pareja.getTitulo());
        tvtitulotu.setText(tu.getTitulo());
        tvdescripciontupareja.setText(pareja.getDescripcionAmorosa());
        tvdescriciontu.setText(tu.getDescripcionAmorosa());

    }
    private void tarotPareja(int numero, int numerotupersona) {
        String nombreCarta = String.format("carta%d", numero);
        String nombreCartatupersona = String.format("carta%d", numerotupersona);
        int valorimagencarta = getResources().getIdentifier(nombreCarta, "drawable", getPackageName());
        int valorimagencartatupersona = getResources().getIdentifier(nombreCartatupersona, "drawable", getPackageName());
        ivcartatu.setImageResource(valorimagencarta);
        ivcartatupareja.setImageResource(valorimagencartatupersona);

    }
}