package com.pt2.prawdafalsz;

import java.util.ArrayList;

public class Repozytorium {
    static ArrayList<Pytanie> zwrocWszyskiePytania()
    {
        ArrayList<Pytanie> pytanie = new ArrayList<>();
        pytanie.add(new Pytanie("Czy na obrazie jest drzewo",R.drawable.drzewo,true,"No jak kurde myslisz",0));

        pytanie.add(new Pytanie("Czy na obrazie jest creeper minecraft",R.drawable.creeper_img,true,"Może",0));

        pytanie.add(new Pytanie("Czy dostane 6",R.drawable.a3dgoldennumber6png,true,"Wybitni uczniowie powinni taką ocene dostać",0));

        pytanie.add(new Pytanie("Czy w strefie gazu w izraelu doszło do ludobójstwa",R.drawable.juw,true,"Tak",0));

        pytanie.add(new Pytanie("Czy bydgoszcz znajduje sie w polsce?",R.drawable.bydgoszczy,false,"Ja bym się wstydził",0));
        return pytanie;
    }
}
