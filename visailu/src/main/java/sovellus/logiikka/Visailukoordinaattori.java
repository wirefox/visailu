package sovellus.logiikka;

import java.util.HashMap;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.GraafinenKayttoliittyma;

/**
 * Luokka ohjaa visailua ylätasolta ja valmistelee ohjelman pelaamista varten.
 *
 * @author elina
 */
public class Visailukoordinaattori {

    private Peli peli;
    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;
    HashMap<String, String> kysymyksetJaVastaukset;

    /**
     * Metodissa luodaan tiedostonlukijaolio ja pyydetään tätä lukemaan pelaajan
     * valitseman pelin tiedosto.
     *
     * @param String pelinNimi pelaajan valitseman pelin nimi
     *
     */
    public void lueTiedosto(String pelinNimi) {
        this.tiedostonlukija = new Tiedostonlukija();
        this.kysymyksetJaVastaukset = new HashMap<>();

        switch (pelinNimi) {
            case "valtiot ja pääkaupungit":
                this.kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt");
                break;
            case "kiinan numerot":
                this.kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("kiinaNumerot.txt");
                break;
        }
    }

    /**
     * Metodissa luodaan tiedonkäsittelijäolio ja pyydetään sitä luomaan ja
     * muodostamaan pelin kysymyssarja ja sekoittamaan se.
     *
     * @return kysymyssarja metodi palauttaa pelissä käytettävän kysymyssarjan.
     */
    public Kysymyssarja muodostaKysymyssarja() {
        this.tiedonkasittelija = new Tiedonkasittelija(kysymyksetJaVastaukset, this.tiedostonlukija.getKysymyslause());
        Kysymyssarja kysymyssarja = this.tiedonkasittelija.muodostaKysymyssarja();
        kysymyssarja.sekoitaSarjanKysymykset();

        return kysymyssarja;
    }

    public HashMap<String, String> getKysymyksetJaVastaukset() {
        return this.kysymyksetJaVastaukset;
    }
}
