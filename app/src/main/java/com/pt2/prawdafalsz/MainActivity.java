package com.pt2.prawdafalsz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    //Obiekty
    ArrayList<Pytanie> pytania;
    private int aktualnePytanie = 0;
    TextView pytanieGlowne;

    Button takPrzycisk;

    Button niePrzycisk;

    Button podpowiedzPrzycisk;

    Button nastepnePrzycisk;

    ImageView obrazGlowny;

    LinearLayout glownyLayout;
    TextView podpowiedzPole;
    Random random = new Random();
    static ArrayList<Integer> czyWykorzystano = new ArrayList<>();
    private ArrayList<Pytanie> pytanie = new ArrayList<>();

    static int nrPytania = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pytania = Repozytorium.zwrocWszyskiePytania();

        pytanieGlowne = findViewById(R.id.trescPytaniaId);

        takPrzycisk = findViewById(R.id.prawdaPrzycisk);

        podpowiedzPrzycisk = findViewById(R.id.podpowiedzPrzycisk);

        nastepnePrzycisk = findViewById(R.id.nastepneId);

        niePrzycisk = findViewById(R.id.falszPrzycisk);

        obrazGlowny = findViewById(R.id.obrazGlownyId);

        podpowiedzPole = findViewById(R.id.podpowiedzPole);

        glownyLayout = findViewById(R.id.glownyLayout);

        pytanie = Repozytorium.zwrocWszyskiePytania();
        //zresetujPytania();

        nastepnePrzycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zmienPytanie();
            }
        });
        podpowiedzPrzycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //wyswietlPodpowiedz(nrPytania);
                //aktualnePytanie = nrPytania;
                aktualnePytanie = nrPytania;
                Intent intencja = new Intent(MainActivity.this,PodpowiedzActivity.class);
                intencja.putExtra("KTOREPYTANIE",aktualnePytanie);
                startActivity(intencja);
            }
        });
        niePrzycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                falszPrzycisk(nrPytania);
            }
        });
        takPrzycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prawdaPrzycisk(nrPytania);
            }
        });




        ustawPytanie(nrPytania);

    }

    public void ustawPytanie(int id)
    {
        obrazGlowny.setImageResource(pytanie.get(id).getIdObrazka());
        pytanieGlowne.setText(pytanie.get(id).getTrescPytania());


    }
    static int punkty = 0;
    public void zmienPytanie()
    {
        if (nrPytania < pytanie.size()-1) {
            niePrzycisk.setBackgroundColor(Color.rgb(103,80,163));
            takPrzycisk.setBackgroundColor(Color.rgb(103,80,163));
            nrPytania++;
            podpowiedzPole.setText("");
            ustawPytanie(nrPytania);
        }
        else
        {
            ukryj();
            wyswietlTest();
        }
    }
    public void zresetujPytania()
    {
        pytanie.add(new Pytanie("Czy na obrazie jest drzewo",R.drawable.drzewo,true,"No jak kurde myslisz",0));

        pytanie.add(new Pytanie("Czy na obrazie jest creeper minecraft",R.drawable.creeper_img,true,"Może",0));

        pytanie.add(new Pytanie("Czy dostane 6",R.drawable.a3dgoldennumber6png,true,"Wybitni uczniowie powinni taką ocene dostać",0));

        pytanie.add(new Pytanie("Czy w strefie gazu w izraelu doszło do ludobójstwa",R.drawable.juw,true,"Tak",0));

        pytanie.add(new Pytanie("Czy bydgoszcz znajduje sie w polsce?",R.drawable.bydgoszczy,false,"Ja bym się wstydził",0));
    }
    public void ukryj()
    {
        takPrzycisk.setVisibility(View.INVISIBLE);
        niePrzycisk.setVisibility(View.INVISIBLE);
        obrazGlowny.setVisibility(View.INVISIBLE);
        nastepnePrzycisk.setVisibility(View.INVISIBLE);
        podpowiedzPrzycisk.setVisibility(View.INVISIBLE);
        podpowiedzPole.setVisibility(View.INVISIBLE);
    }
    public void wyswietlTest()
    {
        pytanieGlowne.setText("Test zakończony!\nIlość punktów: " + punkty);
    }

    public void wyswietlPodpowiedz(int id)
    {
        podpowiedzPole.setText(pytanie.get(id).getPodpowiedz());
    }
    public void prawdaPrzycisk(int id)
    {

            takPrzycisk.setBackgroundColor(Color.GREEN);
            niePrzycisk.setBackgroundColor(Color.rgb(103,80,163));
            // 1 - Prawda    2 - Fałsz
            if (pytanie.get(id).isOdpowiedz())
            {
                pytanie.get(id).setCzyDobrzeOdpowiedziano(1);
                if (!pytanie.get(nrPytania).isCzyWykorzystanoPodpowiedz())
                {
                    punkty = + punkty + 2;
                }
                else
                {
                    punkty++;
                }
            }
            else
            {
                pytanie.get(id).setCzyDobrzeOdpowiedziano(2);
            }
    }
    public void falszPrzycisk(int id)
    {
        niePrzycisk.setBackgroundColor(Color.RED);
        takPrzycisk.setBackgroundColor(Color.rgb(103,80,163));
        // 1 - Prawda    2 - Fałsz
        if (!pytanie.get(id).isOdpowiedz())
        {
            pytanie.get(id).setCzyDobrzeOdpowiedziano(1);
            if (!pytanie.get(nrPytania).isCzyWykorzystanoPodpowiedz())
            {
                punkty = + punkty + 2;
            }
            else
            {
                punkty++;
            }
        }
        else
        {
            pytanie.get(id).setCzyDobrzeOdpowiedziano(2);
        }
    }
}
