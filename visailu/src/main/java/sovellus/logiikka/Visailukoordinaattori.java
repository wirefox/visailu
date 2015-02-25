package sovellus.logiikka;

import java.util.HashMap;
import sovellus.domain.Kysymyssarja;

/**
 * Luokka ohjaa visailua ylätasolta ja valmistelee pelaajan valitseman pelin
 * pelaamista varten.
 *
 * @author elina
 */
public class Visailukoordinaattori {

    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;
    private Peli peli;
    HashMap<String, String> kysymyksetJaVastaukset;

    /**
     * Metodissa luodaan tiedostonlukijaolio ja pyydetään tätä lukemaan pelaajan
     * valitseman pelin tiedosto HashMapiin.
     *
     * @param pelinNimi Metodi saa pelin nimen parametrina.
     */
    public void lueTiedosto(String pelinNimi) {
        this.tiedostonlukija = new Tiedostonlukija();
        this.kysymyksetJaVastaukset = new HashMap<>();

        if (pelinNimi.equals("valtiot ja pääkaupungit")) {
            this.kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt");
        } else if (pelinNimi.equals("kiinan numerot")) {
            this.kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("kiinaNumerot.txt");
        }
    }

    /**
     * Metodissa luodaan tiedonkäsittelijäolio ja pyydetään sitä luomaan ja
     * muodostamaan pelin kysymykset ja kysymyssarja, ja sekoittamaan
     * kysymyssarjan järjestys.
     *
     * @return kysymyssarja Metodi palauttaa pelissä käytettävän kysymyssarjan.
     */
    public Kysymyssarja muodostaKysymyssarja() {
        this.tiedonkasittelija = new Tiedonkasittelija(kysymyksetJaVastaukset, this.tiedostonlukija.getKysymyslause());
        Kysymyssarja kysymyssarja = this.tiedonkasittelija.muodostaKysymyssarja();
        kysymyssarja.sekoitaSarjanKysymykset();

        return kysymyssarja;
    }

    /**
     * Metodissa luodaan peli-olio ja annetaan sille konstruktorin parametrina
     * kysymyssarja-olio.
     *
     * @param kysymyssarja Kysymyssarja
     */
    public void luoUusiPeli(Kysymyssarja kysymyssarja) {
        this.peli = new Peli(kysymyssarja);
    }

    public HashMap<String, String> getKysymyksetJaVastaukset() {
        return this.kysymyksetJaVastaukset;
    }

    public Peli getPeli() {
        return this.peli;
    }
}
