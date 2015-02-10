package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

/**
 * Luokassa jatkokäsitellään tiedostonlukijan sisään lukemaa tietoa
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
     * Metodissa luodaan kysymykset, niiden muuttujat sekä kysymyssarja, jonne
     * kysymykset lisätään.
     *
     * Jokaiselle luodulle kysymykselle lisätään kysymyssana, oikea vastaus ja
     * väärät vastaukset.
     *
     * @return kysymyssarja palautetaan valmis kysymyssarja
     */
    public Kysymyssarja muodostaKysymyssarja() {
        Kysymyssarja kysymyssarja = new Kysymyssarja(this.kysymyslause);
        for (String kysymyssana : this.kysymyksetJaVastaukset.keySet()) {

            Kysymys kysymys = new Kysymys();
            kysymys.setKysymyssana(kysymyssana.toUpperCase());
            kysymys.setOikeaVastaus(this.kysymyksetJaVastaukset.get(kysymyssana));
            kysymys.setVaaratVastaukset(arvoVaaratVastausvaihtoehdot(kysymys));

            kysymyssarja.lisaaKysymys(kysymys);

        }
        return kysymyssarja;
    }

    public HashMap<String, String> getKysymyksetJaVastaukset() {
        return this.kysymyksetJaVastaukset;
    }

    /**
     * Metodissa arvotaan kysymykselle väärät vastausvaihtoehdot.
     *
     * Metodissa luodaan uusi vastausarpoja, jolta pyydetään neljä väärää
     * vastausvaihtoehtoa.
     *
     * @param kysymys metodille annetaan pelikierroksen kysymys, jolle väärät
     * vastausvaihtoehdot tulee arpoa.
     * @return vaaratVastaukset metodi palauttaa listan, jossa on kysymyksen
     * väärät vastausvaihtoehdot.
     */
    private ArrayList<String> arvoVaaratVastausvaihtoehdot(Kysymys kysymys) {
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
