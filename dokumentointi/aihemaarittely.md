# Aihemäärittely

## Aihe: 
Kyseessä on visailusovellus/hyötypeli. Visailussa pelaaja oppii pelin avulla asioita mukavalla tavalla ja helposti. Pelaaja valitsee aloitusnäkymästä haluamansa pelin. Pelaajan pelatessa näkee hän kuinka monta kysymyksistä on mennyt oikein (xx/xx). Pelin lopussa pelaajalle näytetään lopputulos.

## Käyttäjät: 
Visailun pelaajat

## Käyttäjien toiminnot:
- sovelluksen pääsivulla pelien listauksen katsominen
- pelin valitseminen jota haluaa pelata
- pelin pelaaminen kierros kierrokselta
- pelin aikana pisteiden näkeminen
- pelin lopuksi lopputuloksen (pisteiden) näkeminen

## Pelin ajatellut luokat ja niiden toiminnallisuus lyhyesti:

- sovellus.domain:
  - Main (luo visailukoordinaattorin ja graafisenKayttoliittyman ja pyytää sitä käynnistymään)
  - Kysymys (kysymysolio, johon tallennettuna kysymyssana, oikea vastaus sekä väärät vastaukset; getterit ja setterit. Kysymyksen vastauksen tarkistus)
  - Kysymyssarja (kysymysoliot talletetaan kysymyssarjaan. Kysymyssarja tietää myös pelin kysymyslauseen. Sekoittaa listan, jossa kysymys-oliot ovat, jotta joka pelissä kysymykset eivät tule samassa järjestyksessä. Kysymyssarja antaa pelin jokaiselle kierrokselle kysymyksen listaltaan)

- sovellus.gui:
  - GraafinenKayttoliittyma (luodaan pelin aloitusikkunaan komponentit, sekä päivitetään ikkuna ja luodaan uudet komponentit, jolloin siitä tulee peli-ikkuna)
  - Tapahtumankuuntelija

- sovellus.logiikka:
  - Visailukoordinaattori (koordinoi visailua, valmistelee oikean visan käynnistyksen)
  - Tiedostonlukija (lukee tiedoston sisään HashMapiin, tiedoston ekalta riviltä myös visan kysymyslauseen)
  - Tiedonkasittelija (käsittelee luetun tiedon ja muodostaa siitä kysymyksiä, jotka talletetaan kysymyssarjaan)
  - Vastausarpoja (arpoo väärät vastausvaihtoehdot jokaiselle pelin kierrokselle)
  - Peli (pyörittää pelin kierroksen ja pitää huolta kierros- ja pistetilanteesta)
