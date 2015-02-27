# Aihemäärittely ja ohjelman rakennekuvaus

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

## Ohjelman rakenne

### Pelin luokat ja niiden toiminnallisuus lyhyesti:

- sovellus.domain:
  - Main (Luo visailukoordinaattorin sekä graafisenKayttoliittyman ja pyytää sitä käynnistymään)
  - Kysymys (Kysymysolio, johon on talletettuna kysymyssana, oikea vastaus sekä väärät vastaukset; getterit ja setterit. Kysymyksen vastauksen tarkistus)
  - Kysymyssarja (Tallettaa kysymysoliot listaan. Sekoittaa listan, jotta joka pelissä kysymykset eivät tule samassa järjestyksessä. Kysymyssarja antaa pelin jokaiselle kierrokselle kysymyksen listaltaan. Kysymyssarja tietää pelin kysymyslauseen.)

- sovellus.gui:
  - GraafinenKayttoliittyma (Pelin aloitusikkuna ja peli-ikkuna: luo pelin aloitusikkunaan komponentit, joista pelaaja valitsee pelin. Päivittää ikkunan ja luo uudet komponentit, jolloin ikkunasta tulee pelin pelaamisikkuna)
  - Tapahtumankuuntelija (Kuuntelee pelaajan valintoja ja käskyttää peliä eteenpäin tarvitulla tavalla)

- sovellus.logiikka:
  - Visailukoordinaattori (Ohjaa visailua ylätasolta, valmistelee oikean visan käynnistyksen eli käskee tiedostonlukijaa lukemaan oikean tiedoston sisään ja tiedonkäsittelijää muodostamaan siitä kysymyksiä ja kysymyssarjan)
  - Tiedostonlukija (Lukee tiedoston sisään kysymys(string)-vastaus(string) -HashMapiin. Lukee tiedoston ensimmäiseltä riviltä myös visan kysymyslauseen)
  - Tiedonkasittelija (Jatkokäsittelee tiedostonlukijan sisään lukemaa tietoa (HashMap); luo kysymysolioita ja kysymyssarjan, jonne lisää kysymysoliot. Lisää kysymysolion muuttujille tietoja; pyytää vastausvaihtoehdot vastausvaihtoehtoArpojalta)
  - VastausvaihtoehtoArpoja (Arpoo väärät vastausvaihtoehdot (4 kpl) jokaiselle kysymykselle)
  - Peli (Pelin pelaamisen toiminnallisuus. Talletettuna kysymyssarja-olio, kierroksen kysymysolio sekä kierroksen numero ja pelaajan pistetilanne)
