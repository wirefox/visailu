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
    private GraafinenKayttoliittyma graafinenKayttis;

    /**
     * Metodissa valmistellaan pelaajan valitsema peli pelausvalmiiksi.
     *
     * Kutsutaan olion omia lueTiedosto-, muodostaKysymyssarja- ja
     * visaile-metodeja.
     *
     * @param kayttoliittyma graafinen käyttöliittymä -olio
     * @param pelinNimi pelaajan valitseman pelin nimi
     */
    public void pelinValmistelutoimet(GraafinenKayttoliittyma kayttoliittyma, String pelinNimi) {
        this.graafinenKayttis = kayttoliittyma;
        HashMap<String, String> kysymyksetJaVastaukset = lueTiedosto(pelinNimi);
        String kysymyslause = this.tiedostonlukija.getKysymyslause();
        Kysymyssarja kysymyssarja = muodostaKysymyssarja(kysymyksetJaVastaukset, kysymyslause);
        visaile(kysymyssarja);
    }

    /**
     * Metodissa luodaan tiedostonlukijaolio ja pyydetään tätä lukemaan pelaajan
     * valitseman pelin tiedosto.
     *
     * @param String pelinNimi pelaajan valitseman pelin nimi
     *
     * @return kysymyksetJaVastaukset metodi palauttaa HashMapin, jossa on
     * luetusta tiedostosta muodostetut kysymys-vastaus -parit.
     */
    private HashMap<String, String> lueTiedosto(String pelinNimi) {
        this.tiedostonlukija = new Tiedostonlukija();
        HashMap<String, String> kysymyksetJaVastaukset = new HashMap<>();

        switch (pelinNimi) {
            case "valtiot ja pääkaupungit":
                kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("maatJaPaakaupungit.txt");
                break;
            case "kiinan numerot":
                kysymyksetJaVastaukset = this.tiedostonlukija.lueTiedosto("kiinaNumerot.txt");
                break;
        }
        return kysymyksetJaVastaukset;
    }

    /**
     * Metodissa luodaan tiedonkäsittelijäolio ja pyydetään sitä luomaan ja
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
     * Metodissa luodaan peli-olio ja pyydetään käyttöliittymää päivittämään
     * ikkuna pelaamista varten.
     *
     * @param kysymyslause metodi saa parametrina pelissä käytettävän
     * kysymyslauseen
     * @param kysymyssarja metodi saa parametrina pelissä käytettävän
     * kysymyssarjan
     */
    private void visaile(Kysymyssarja kysymyssarja) {
        this.peli = new Peli(kysymyssarja);
        this.graafinenKayttis.luoKomponentitPeliIkkunaan(this.graafinenKayttis.getFrame().getContentPane(), peli);
    }
}
