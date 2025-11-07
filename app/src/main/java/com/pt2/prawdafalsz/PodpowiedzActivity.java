package com.pt2.prawdafalsz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PodpowiedzActivity extends AppCompatActivity {

    public TextView textPole;

    public ImageView obrazek;
    ArrayList<Pytanie> pytania;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_podpowiedz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intencja = getIntent();
        int ktore = intencja.getIntExtra("KTOREPYTANIE",0);
        pytania = Repozytorium.zwrocWszyskiePytania();
        textPole = findViewById(R.id.podpowiedzTutaj);
        obrazek = findViewById(R.id.ObrazekPytanie);

        textPole.setText("Podpowiedź do pytania nr: " + (ktore+1) + "\n"+  pytania.get(ktore).getPodpowiedz());
        obrazek.setImageResource(pytania.get(ktore).getIdObrazka());
        pytania.get(ktore).setCzyWykorzystanoPodpowiedz(true);

    }
}