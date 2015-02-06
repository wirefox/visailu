package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

/**
 * Luokka käsittelee saamansa HashMapin muodostaen siitä peliä varten kysymyksiä
 * ja kysymyssarjan
 *
 * @author elina
 */
public class Tiedonkasittelija {

    private HashMap<String, String> kysymyksetJaVastaukset;
    private String kysymyslause;

    public Tiedonkasittelija(HashMap<String, String> kysymyksetJaVastaukset, String kysymyslause) {
        this.kysymyksetJaVastaukset = kysymyksetJaVastaukset;
        this.kysymyslause = kysymyslause;
    }

    /**
     * Metodi muodostaa
     * antaa kysymyslauseen eteenpäin kysymyssarjalle
     */
    public Kysymyssarja muodostaKysymyssarja() {
        Kysymyssarja kysymyssarja = new Kysymyssarja(this.kysymyslause);
        for (String kysymyssana : this.kysymyksetJaVastaukset.keySet()) {

            Kysymys kysymys = new Kysymys();
            kysymys.setKysymyssana(kysymyssana.toUpperCase());
            kysymys.setOikeaVastaus(this.kysymyksetJaVastaukset.get(kysymyssana));
            kysymys.setVaaratVastaukset(arvoVaaratVastaukset(kysymys));

            kysymyssarja.lisaaKysymys(kysymys);

        }
        return kysymyssarja;
    }

    public HashMap<String, String> getKysymyksetJaVastaukset() {
        return this.kysymyksetJaVastaukset;
    }

    /**
     * Metodi
     */
    private ArrayList<String> arvoVaaratVastaukset(Kysymys kysymys) {
        ArrayList<String> kaikkiVastaukset = new ArrayList<String>();
        for (String vastaus : this.kysymyksetJaVastaukset.values()) {
            kaikkiVastaukset.add(vastaus);
        }
        Vastausarpoja vastausarpoja = new Vastausarpoja();
        ArrayList<String> vaaratVastaukset = new ArrayList<String>();
        vaaratVastaukset = vastausarpoja.arvoVastauksetKysymykselle(kaikkiVastaukset, kysymys);
        return vaaratVastaukset;
    }
}
