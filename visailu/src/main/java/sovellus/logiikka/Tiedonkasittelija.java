package sovellus.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

public class Tiedonkasittelija {

    private Kysymys kysymys;
    private HashMap<String, String> kysymyksetJaVastaukset;

    public Tiedonkasittelija(HashMap<String, String> kysymyksetJaVastaukset) {
        this.kysymyksetJaVastaukset = kysymyksetJaVastaukset;
    }

    public Kysymyssarja muodostaKysymyssarja() {
        Kysymyssarja kysymyssarja = new Kysymyssarja();
        for (String kysymyssana : this.kysymyksetJaVastaukset.keySet()) {
            this.kysymys = new Kysymys();
            this.kysymys.lisaaKysymyssana(kysymyssana);
            this.kysymys.lisaaOikeaVastaus(this.kysymyksetJaVastaukset.get(kysymyssana));
            this.kysymys.lisaaVaaratVastaukset(arvoVaaratVastaukset());

            kysymyssarja.lisaaKysymys(this.kysymys);
        }
        return kysymyssarja;
    }

    private ArrayList<String> arvoVaaratVastaukset() {
        ArrayList<String> kaikkiVastaukset = new ArrayList<String>();
        for (String vastaus : this.kysymyksetJaVastaukset.values()) {
            kaikkiVastaukset.add(vastaus);
        }

        Vastausarpoja vastausarpoja = new Vastausarpoja(this.kysymys);
        ArrayList<String> vaaratVastaukset = new ArrayList<String>();

        //annetaan kaikki mahdolliset vastaukset metodin parametrina Vastausarpojalle
        //ja pyydetään sitä arpomaan meille yhden kysymyksen väärät vastausvaihtoehdot
        vaaratVastaukset = vastausarpoja.arvoVastauksetKysymykselle(kaikkiVastaukset);
        return vaaratVastaukset;
    }
}
