package com.pt2.prawdafalsz;

public class Pytanie {
    public String trescPytania;
    private int idObrazka;
    private boolean odpowiedz;
    private String podpowiedz;

    private int czyDobrzeOdpowiedziano;

    private boolean czyWykorzystanoPodpowiedz;

    public Pytanie(String trescPytania, int idObrazka, boolean odpowiedz, String podpowiedz, int czyDobrzeOdpowiedziano) {
        this.trescPytania = trescPytania;
        this.idObrazka = idObrazka;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        this.czyDobrzeOdpowiedziano = czyDobrzeOdpowiedziano;
        czyWykorzystanoPodpowiedz = false;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public int getCzyDobrzeOdpowiedziano() {
        return czyDobrzeOdpowiedziano;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }

    public void setCzyDobrzeOdpowiedziano(int czyDobrzeOdpowiedziano) {
        this.czyDobrzeOdpowiedziano = czyDobrzeOdpowiedziano;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(boolean odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public boolean isCzyWykorzystanoPodpowiedz() {
        return czyWykorzystanoPodpowiedz;
    }

    public void setCzyWykorzystanoPodpowiedz(boolean czyWykorzystanoPodpowiedz) {
        this.czyWykorzystanoPodpowiedz = czyWykorzystanoPodpowiedz;
    }

    public void setPodpowiedz(String podpowiedz) {
        this.podpowiedz = podpowiedz;
    }
}
