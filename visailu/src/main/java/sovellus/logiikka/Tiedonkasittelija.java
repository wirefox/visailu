package sovellus.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

/**
 * Luokassa jatkokäsitellään tiedostonlukijan sisään lukemaa tietoa; luodaan
 * kysymysolioita ja kysymyssarja, jonne kysymysoliot lisätään.
 *
 * @author elina
 */
public class Tiedonkasittelija {

    private VastausvaihtoehtoArpoja vastausvaihtoehtoArpoja;
    private HashMap<String, String> kysymyksetJaVastaukset;
    private String kysymyslause;

    /**
     * Konstruktori luo tiedonkasittelijaolion ja vastausvaihtoehtoArpojaolion.
     *
     * @param kysymyksetJaVastaukset Saa kysymys-vastaus -HashMapin.
     * @param kysymyslause Saa pelin kysymyslauseen.
     */
    public Tiedonkasittelija(HashMap<String, String> kysymyksetJaVastaukset, String kysymyslause) {
        this.kysymyksetJaVastaukset = kysymyksetJaVastaukset;
        this.kysymyslause = kysymyslause;
        this.vastausvaihtoehtoArpoja = new VastausvaihtoehtoArpoja();
    }

    /**
     * Metodissa luodaan kysymysoliot, niiden muuttujat sekä kysymyssarjaolio,
     * jonne kysymysoliot lisätään.
     *
     * Jokaiselle luodulle kysymysoliolle lisätään kysymyssana, oikea vastaus ja
     * väärät vastaukset.
     *
     * @return kysymyssarja Palautetaan valmis kysymyssarjaolio
     */
    public Kysymyssarja muodostaKysymyssarja() {
        Kysymyssarja kysymyssarja = new Kysymyssarja(this.kysymyslause);
        for (String kysymyssana : this.kysymyksetJaVastaukset.keySet()) {

            Kysymys kysymys = new Kysymys();
            kysymys.setKysymyssana(kysymyssana.toUpperCase());
            kysymys.setOikeaVastaus(this.kysymyksetJaVastaukset.get(kysymyssana));
            ArrayList<String> vaaratVastausvaihtoehdot = annaKysymyksenVaaratVastausvaihtoehdot(kysymys);
            kysymys.setVaaratVastaukset(vaaratVastausvaihtoehdot);

            kysymyssarja.lisaaKysymys(kysymys);

        }
        return kysymyssarja;
    }

    public HashMap<String, String> getKysymyksetJaVastaukset() {
        return this.kysymyksetJaVastaukset;
    }

    /**
     * Metodissa arvotaan kysymysoliolle väärät vastausvaihtoehdot.
     *
     * Metodissa luodaan uusi vastausvaihtoehtoArpojaolio, jolta pyydetään neljä
     * väärää vastausvaihtoehtoa.
     *
     * @param kysymys Metodille annetaan kysymysolio, jolle väärät
     * vastausvaihtoehdot tulee arpoa.
     * @return vaaratVastaukset Metodi palauttaa listan, jossa on kysymysolion
     * väärät vastausvaihtoehdot.
     */
    private ArrayList<String> annaKysymyksenVaaratVastausvaihtoehdot(Kysymys kysymys) {
        ArrayList<String> kaikkiVastaukset = new ArrayList<>();
        for (String vastaus : this.kysymyksetJaVastaukset.values()) {
            kaikkiVastaukset.add(vastaus);
        }
        ArrayList<String> vaaratVastaukset = this.vastausvaihtoehtoArpoja.arvoVastausvaihtoehdotKysymykselle(kaikkiVastaukset, kysymys);
        return vaaratVastaukset;
    }
}
