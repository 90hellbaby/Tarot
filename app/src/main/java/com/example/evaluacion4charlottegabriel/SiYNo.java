package com.example.evaluacion4charlottegabriel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evaluacion4charlottegabriel.Dao.Carta;

import java.util.Arrays;

public class SiYNo extends AppCompatActivity {
    private TextView tvresultado;
    private ImageView ivcarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_yno);

        // Vincular los elementos de la vista
        TextView tvtitulo = findViewById(R.id.Siynotitulocarta);
        TextView tvdescripcion = findViewById(R.id.Siynodescripcion);
        tvresultado = findViewById(R.id.Siynoresultado);
        ivcarta = findViewById(R.id.Siynoimagencarta);

        // Obtener los extras del intent
        Bundle bundle = getIntent().getExtras();
        int numero = bundle.getInt("numero");
        int rotacion = bundle.getInt("rotacion");
        Carta carta = (Carta) bundle.getSerializable("carta");

        // Mostrar la informacion de la carta
        if (rotacion == 0) {
            tvdescripcion.setText(carta.getDescripcion());
            tvtitulo.setText(carta.getTitulo());
        } else {
            tvdescripcion.setText(carta.getDescripcionInvertida());
            tvtitulo.setText(carta.getTitulo() + " invertida");
        }

        // Mostrar imagen y resultado
        SiNoQuizas(numero, rotacion);
    }

    private void SiNoQuizas(int numero, int rotacion) {
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

        // Determinar resultado
        String resultado;
        if (Arrays.asList(si).contains(numero)) {
            resultado = "Tu respuesta es si₍ᐢ. ̫ .ᐢ₎";
        } else if (Arrays.asList(no).contains(numero)) {
            resultado = "Tu respuesta es no lo siento(ó﹏ò｡)";
        } else {
            resultado = "(ง ˃ ³ ˂)ว ⁼³₌₃⁼³ Tu respuesta es talves";
        }
        tvresultado.setText(resultado);

        // Determinar imagen y mostrarla
        String nombreCarta = String.format("carta%d", numero);
        int valorimagencarta = getResources().getIdentifier(nombreCarta, "drawable", getPackageName());
        ivcarta.setImageResource(valorimagencarta);
        ivcarta.setRotation(rotacion);
    }
}