package sovellus.logiikka;

import sovellus.domain.Kysymyssarja;

public class Peli {

    private Kysymyssarja kysymyssarja;
    //tässä pitäisi ehkä olla muuttujina:
    //kierroksen numero
    //kuinka paljon pelaajalla tällä hetkellä pisteitä
    //Kysymyssarja
    //Scanner, nyt kun ei ole graafista käyttistä
    //oikea vastaus

    public Peli(Kysymyssarja kysymyssarja) {
        this.kysymyssarja = new Kysymyssarja();
    }

    public void pelaaKierros() {
        System.out.println("Mikä on ylläolevan valtion pääkaupunki, valitse allaolevista vaihtoehdoista:");
        annaVaihtoehdot();

        System.out.print("Kirjoita arvauksesi: ");
        //luetaan pelaajan vastaus

        // annetaan pelaajan vastaus VastauksenArviointi(vastaus)-metodille.
        pistetilanteenTulostus();

        //lisätään kierroksen numeroa
    }

    public boolean onkoVikaKierros() {
        // tässä metodissa tarkastetaan, onko kyseessä viimeinen kierros.
        // eli jatketaanko pelaamista vai ei
        return true;
    }

    public int getPisteitaKasassa() {
        return -99;
    }

    private void annaVaihtoehdot() {
        // tässä metodissa annetaan pelaajalle kaikki vastausvaihtoehdot
    }

    private void vastauksenArviointi(String vastaus) {
        //tässä metodissa tarkastetaan pelaajan vastaus:
        //jos oikea vastaus, tulee yksi piste lisää
        //jos väärä vastaus, kerrotaan mikä olisi ollut oikea vastaus
    }

    private void pistetilanteenTulostus() {
        //Tässä metodissa kerrotaan pelaajalle kuinka paljon hänellä on pisteitä
        //muodossa pelaajan pisteet / kaikki kysytyt kysymykset
    }
}
