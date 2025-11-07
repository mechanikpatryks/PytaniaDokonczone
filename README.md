<h1>Pytania quiz:</h1>

Zadanie polegało na wykonaniu quizu z
- opcją podpowiedzi
- obrazem
- repozytorium pytań
- nowym activity

  <h1>
    Najważniejsze rzeczy:
  </h1>
<h2>Tworzenie intencji</h2>
Intent intencja = new Intent(MainActivity.this,PodpowiedzActivity.class);
intencja.putExtra("KTOREPYTANIE",aktualnePytanie);
startActivity(intencja);
<h2>Tworzenie listenerów</h2>
        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warunki()
            }
<h2>Tworzenie arraylisty z obiektem innej klasy</h2>
    private ArrayList<Klasa> pytanie = new ArrayList<>();
