# Aihemäärittely

## Aihe: 
Visailusovellus, hyötypeli. Kyseessä on visailusovellus, joka tehdään helposti laajennettavaksi. Visailussa pelaaja oppii pelin avulla asioita mukavalla tavalla. Alussa sovellus sisältää yhden pelin, pääkaupunkivisan, jossa pelaaja arvaa maiden pääkaupunkeja. Jatkossa sovellukseen voi lisätä erilaisia visoja, esimerkiksi toisenlaisen tietovisan, eri kielten harjoitteluvisoja ym.
Alussa peli on automaattisesti pääkaupunkivisailu, mutta jos pelejä on useita, valitsee pelaaja  aloitusnäkymästä haluamansa pelin. Pelaajan pelatessa näkee hän kuinka monta kysymyksistä on mennyt oikein (xx/xx). Pelin lopussa pelaajalle näytetään lopputulos. Tästä näkymästä pelaaja voi jatkaa saman pelin pelaamista, tai siirtyä takaisin pääsivulle.

## Käyttäjät: 
Visailun pelaajat

## Käyttäjien toiminnot:
- sovelluksen pääsivulla pelien listauksen selaaminen
- pelin valitseminen, jota haluaa pelata
- pelin pelaaminen
- pelin aikana pisteiden näkeminen
- pelin lopuksi lopputuloksen katsominen

## Pelin ajatellut luokat ja niiden toiminnallisuus lyhyesti:

- sovellus.domain:
  - Main (käynnistää visailukoordinaattorin)
  - Kysymys
  - Kysymyssarja

- sovellus.gui:
  - Kayttoliittyma (ei vielä aloitettu toteuttamaan)
  - Tapahtumankuuntelija (ei vielä aloitettu toteuttamaan)

- sovellus.logiikka:
  - Visailukoordinaattori (koordinoi visailua, kokonaisuuden hallinta, GUI:in myöhemmin siirrettäviä osia)
  - Tiedostonlukija (lukee tiedoston sisään HashMapiin)
  - Tiedonkasittelija (käsittelee luetun tiedon ja muodostaa siitä kysymyksiä ja kysymyssarjoja)
  - Vastausarpoja (arpoo väärät vastausvaihtoehdot)
  - Peli (pyörittää pelin kierroksen ja pitää huolta kierros- ja pistetilanteesta, GUI:in myöhemmin siirrettäviä osia)
