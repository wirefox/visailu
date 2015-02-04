package sovellus.logiikka;

import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

/**
 * Luokka ohjaa visailua ylätasolta: visailun käynnistämisestä ja tiedoston lukemiskäskystä
 * pelikierroksen pelaamisen käskyyn ja lopulta pelin lopettamiseen
 */
public class Visailukoordinaattori {

    private Kysymyssarja kysymyssarja;
    private Peli peli;
    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;
    
    public void kaynnista() {
        lueTiedosto();
        muodostaKysymyssarja();
        Tekstikayttoliittyma tekstikayttoliittyma = new Tekstikayttoliittyma();
        visaile(tekstikayttoliittyma);
        tekstikayttoliittyma.tulostaNaytolle(pelinLopetusteksti());
    }

    private void lueTiedosto() {
        this.tiedostonlukija = new Tiedostonlukija();
        this.tiedonkasittelija = new Tiedonkasittelija(this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt"));
    }

    private void muodostaKysymyssarja() {
        this.kysymyssarja = this.tiedonkasittelija.muodostaKysymyssarja();
    }

    private void visaile(Tekstikayttoliittyma tekstikayttoliittyma) {
        this.peli = new Peli(tekstikayttoliittyma, this.tiedostonlukija.getKysymyslause());
        tekstikayttoliittyma.tulostaNaytolle("Hei, tervetuloa visailuun!\n");
        while (true) {
            this.peli.seuraavaKysymys(this.kysymyssarja);
            this.peli.pelaaKierros();
            if (peli.onkoVikaKierros()) {
                return;
            }
        }
    }

    public String pelinLopetusteksti() {
        if (this.peli.getPisteitaPelaajalla() == 20) {
            return "\nOlet loistava, kaikki oikein!";
        } else if (this.peli.getPisteitaPelaajalla() > 15) {
            return "\nHieno suoritus!"; //GUI
        } else if (this.peli.getPisteitaPelaajalla() > 10) {
            return "\nEnemmän kuin puolet oikein!";
        } else if (this.peli.getPisteitaPelaajalla() == 10) {
            return "\nPuolet oikein!";
        } else if (this.peli.getPisteitaPelaajalla() < 10) {
            return "\nVielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)";
        }
        return null;
    }
}