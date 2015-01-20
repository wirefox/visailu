package sovellus.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

public class Tiedonkasittelija {

    private HashMap<String, String> kysymyksetJaVastaukset;

    Tiedonkasittelija(HashMap<String, String> kysymyksetJaVastaukset) {
        this.kysymyksetJaVastaukset = kysymyksetJaVastaukset;
    }

    public Kysymyssarja muodostaKysymyssarja() {
        Kysymyssarja kysymyssarja = new Kysymyssarja();
        for (String kysymysSana : this.kysymyksetJaVastaukset.keySet()) {
            Kysymys kysymys = new Kysymys();
            //pyydetään kysymykseltä:
            //lisäämään kysymyssanan (eli maan nimen)
            //lisäämään oikean vastauksen (eli pääkaupungin nimen)
            //lisäämään väärät vastaukset, jotka on pyydetty arvoVaaratVastaukset-metodilta

            //lisätään lopuksi luotu kysymys kysymyssarjaan
        }
        return kysymyssarja;
    }

    private ArrayList<String> arvoVaaratVastaukset() {
        ArrayList<String> kaikkiVastaukset = new ArrayList<String>();
        for (String vastaus : this.kysymyksetJaVastaukset.values()) {
            kaikkiVastaukset.add(vastaus);
        }

        Vastausarpoja vastausarpoja = new Vastausarpoja();
        ArrayList<String> vaaratVastaukset = new ArrayList<String>();

        //annetaan kaikki mahdolliset vastaukset metodin parametrina Vastausarpojalle
        //ja pyydetään sitä arpomaan meille yhden kysymyksen väärät vastausvaihtoehdot
        return vaaratVastaukset;
    }
}
