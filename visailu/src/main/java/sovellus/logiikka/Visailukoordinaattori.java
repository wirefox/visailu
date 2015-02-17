package sovellus.logiikka;

import java.util.HashMap;
import javax.swing.SwingUtilities;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.GraafinenKayttoliittyma;
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

    //   private Peli peli;
    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;
    private GraafinenKayttoliittyma graafinenKayttis;

    /**
     * Metodissa kutsutaan lueTiedosto-, muodostaKysymyssarja- ja
     * visaile-metodeita.
     *
     * Tähän tarvitaan vielä lisää tietoa.
     */
    public void kaynnistaGUI() {
        this.graafinenKayttis = new GraafinenKayttoliittyma(this);
        SwingUtilities.invokeLater(this.graafinenKayttis);
    }

    public void pelinValmistelutoimet(String pelinNimi) {
        HashMap<String, String> kysymyksetJaVastaukset = lueTiedosto(pelinNimi);
        String kysymyslause = this.tiedostonlukija.getKysymyslause();
        Kysymyssarja kysymyssarja = muodostaKysymyssarja(kysymyksetJaVastaukset, kysymyslause);
        visaile(kysymyslause, kysymyssarja);
    }

    /**
     * Metodissa luodaan tiedostonlukija ja pyydetään lukemaan tiedosto ja peliä
     * varten.
     *
     * @return kysymyksetJaVastaukset metodi palauttaa HashMapin, jossa on
     * luetusta tiedostosta muodostetut kysymys-vastaus -parit.
     */
    public HashMap<String, String> lueTiedosto(String pelinNimi) {
        this.tiedostonlukija = new Tiedostonlukija();
        HashMap<String, String> kysymyksetJaVastaukset = new HashMap<String, String>();

        if (pelinNimi.equals("valtiot ja pääkaupungit")) {
            kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt");
        } else if (pelinNimi.equals("kiinan numerot")) {
            kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("kiinaNumerot.txt");
        }
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
        Peli peli = new Peli(kysymyslause, kysymyssarja);
        //       this.peli.pelaaPeli();
        this.graafinenKayttis.luoKomponentitPeliIkkunaan(this.graafinenKayttis.getFrame().getContentPane(), peli);
    }
}
