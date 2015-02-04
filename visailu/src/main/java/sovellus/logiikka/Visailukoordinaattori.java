package sovellus.logiikka;

import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

/**
 * Luokka ohjaa visailua ylätasolta: visailun käynnistämisestä ja tiedoston
 * lukemiskäskystä pelikierroksen pelaamisen käskyyn ja lopulta pelin
 * lopettamiseen
 */
public class Visailukoordinaattori {

    private Kysymyssarja kysymyssarja;
    private Kysymys kysymys;
    private Peli peli;
    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;

    public void kaynnista() {
        lueTiedosto();
        muodostaKysymyssarja();
        visaile();
    }

    private void lueTiedosto() {
        this.tiedostonlukija = new Tiedostonlukija();
        this.tiedonkasittelija = new Tiedonkasittelija(this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt"));
    }

    private void muodostaKysymyssarja() {
        this.kysymyssarja = this.tiedonkasittelija.muodostaKysymyssarja();
        this.kysymyssarja.sekoitaSarjanKysymykset();
    }

    private void visaile() {
        this.peli = new Peli(this.tiedostonlukija.getKysymyslause());
        this.peli.pelaaPeli(this.kysymyssarja);
        //      pelinLopetusteksti();
    }

//    public String pelinLopetusteksti() {
//        if (this.peli.getPisteitaPelaajalla() == 20) {
//            return "\nOlet loistava, kaikki oikein!";
//        } else if (this.peli.getPisteitaPelaajalla() > 15) {
//            return "\nHieno suoritus!";
//        } else if (this.peli.getPisteitaPelaajalla() > 10) {
//            return "\nEnemmän kuin puolet oikein!";
//        } else if (this.peli.getPisteitaPelaajalla() == 10) {
//            return "\nPuolet oikein!";
//        } else if (this.peli.getPisteitaPelaajalla() < 10) {
//            return "\nVielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)";
//        }
//        return null;
//    }
}
