package sovellus.logiikka;

import java.util.HashMap;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

//KOrjausehdotus: korjaa luokan javadoc-kuvausta
/**
 * Luokka ohjaa visailua ylätasolta ja valmistelee ohjelman pelaamista varten.
 *
 * Luokka tulee olemaan merkityksellisempi, jos/kun visailua laajennetaan siten,
 * että siihen lisätään muitakin pelejä kuin maavisailu. Tässä tapauksessa
 * visailukoordinaatio ehkä loisi käyttöliittymän ja peli alkaisi.
 *
 * @author elina
 */
public class Visailukoordinaattori {

    private Peli peli;
    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;

    /**
     * Metodissa kutsutaan lueTiedosto-, muodostaKysymyssarja- ja
     * visaile-metodeita.
     *
     * Tähän tarvitaan vielä lisää tietoa.
     */
    public void kaynnista() {
        HashMap<String, String> kysymyksetJaVastaukset = lueTiedosto();
        Kysymyssarja kysymyssarja = muodostaKysymyssarja(kysymyksetJaVastaukset, this.tiedostonlukija.getKysymyslause());
        visaile(this.tiedostonlukija.getKysymyslause(), kysymyssarja);
    }

    /**
     * Metodissa luodaan tiedostonlukija ja pyydetään lukemaan tiedosto ja peliä
     * varten.
     *
     * @return kysymyksetJaVastaukset metodi palauttaa HashMapin, jossa on
     * luetusta tiedostosta muodostetut kysymys-vastaus -parit.
     */
    private HashMap<String, String> lueTiedosto() {
        this.tiedostonlukija = new Tiedostonlukija();
        String kysymyslause = this.tiedostonlukija.getKysymyslause();
        HashMap<String, String> kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt");
        return kysymyksetJaVastaukset;
    }

    /**
     * Metodissa luodaan tiedonkäsittelijä ja pyydetään sitä luomaan ja
     * muodostamaan pelin kysymyssarja.
     *
     * @param kysymyksetJaVastaukset metodi saa parametrinaan HashMapin, jossa
     * on pelin kysymys-vastaus -parit.
     * @param kysymyslause metodi saa parametrinaan peli kysymyslauseen.
     * @return kysymyssarja metodi palauttaa pelissä käytettävän kysymyssarjan.
     */
    private Kysymyssarja muodostaKysymyssarja(HashMap<String, String> kysymyksetJaVastaukset, String kysymyslause) {
        this.tiedonkasittelija = new Tiedonkasittelija(kysymyksetJaVastaukset, kysymyslause);
        Kysymyssarja kysymyssarja = this.tiedonkasittelija.muodostaKysymyssarja();
        kysymyssarja.sekoitaSarjanKysymykset();

        return kysymyssarja;
    }

    /**
     * Metodissa luodaan peli-olio ja pyydetään aloittamaan peli.
     *
     * @param kysymyslause metodi saa parametrina pelissä käytettävän
     * kysymyslauseen
     * @param kysymyssarja metodi saa parametrina pelissä käytettävän
     * kysymyssarjan
     */
    private void visaile(String kysymyslause, Kysymyssarja kysymyssarja) {
        this.peli = new Peli(kysymyslause, kysymyssarja);
        this.peli.pelaaPeli();
    }
}
