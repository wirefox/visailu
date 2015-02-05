package sovellus.logiikka;

import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

/**
 * Luokka ohjaa visailua ylätasolta - 
 * se tulee olemaan merkityksellisempi luokka, jos/kun visailua laajennetaan siten,
 * että siihen lisätään muitakin pelejä kuin maavisailu
 */

public class Visailukoordinaattori {

    private Kysymyssarja kysymyssarja;
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
        this.peli = new Peli(this.tiedostonlukija.getKysymyslause(), this.kysymyssarja);
        this.peli.pelaaPeli();
    }
}
