package com.example.evaluacion4charlottegabriel;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    }

    private void SiNoQuizas() {
        int numero = (int) (Math.random() * 78);
        int[] si = {
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
        int[] no = {
                13, 15, 16, 18, 26,
                28, 31, 40, 43, 52,
                54, 56, 57, 58, 59,
                67, 68
        };
        int[] quizas = {
                2, 4, 5, 9, 11,
                12, 39, 42, 51, 53,
                55, 62, 63, 65, 70
        };

    }
}