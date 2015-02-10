package sovellus.logiikka;

import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

/**
 * Luokka ohjaa visailua ylätasolta - se tulee olemaan merkityksellisempi
 * luokka, jos/kun visailua laajennetaan siten, että siihen lisätään muitakin
 * pelejä kuin maavisailu
 *
 * @author elina
 */
public class Visailukoordinaattori {

    private Peli peli;
    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;

    /**
     * Metodi
     */
    public void kaynnista() {
        lueTiedosto();
        visaile();
    }

    /**
     * Metodi
     */
    private void lueTiedosto() {
        this.tiedostonlukija = new Tiedostonlukija();
        String kysymyslause = this.tiedostonlukija.getKysymyslause();
        this.tiedonkasittelija = new Tiedonkasittelija(this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt"), kysymyslause);
    }

    /**
     * Metodi
     */
    private Kysymyssarja muodostaKysymyssarja() {
        Kysymyssarja kysymyssarja = this.tiedonkasittelija.muodostaKysymyssarja();
        kysymyssarja.sekoitaSarjanKysymykset();

        return kysymyssarja;
    }

    /**
     * Metodi
     */
    private void visaile() {
        this.peli = new Peli(this.tiedostonlukija.getKysymyslause(), muodostaKysymyssarja());
        this.peli.pelaaPeli();
    }
}
