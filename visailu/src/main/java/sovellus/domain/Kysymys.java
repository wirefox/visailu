package sovellus.domain;

import java.util.ArrayList;

/**
 * Luokassa luodaan pelin kysymykset: kysymyksen kysymyssanan, oikean vastauksen
 * ja väärien vastausten asetus ja näitä vastaavat getterit
 */
public class Kysymys {

    private String kysymyssana;
    private String oikeaVastaus;
    private ArrayList<String> vaaratVastausvaihtoehdot;

    public Kysymys() {
        this.vaaratVastausvaihtoehdot = new ArrayList<String>();
    }

    public void setKysymyssana(String kysymyssana) {
        this.kysymyssana = kysymyssana.toUpperCase();
    }

    public void setOikeaVastaus(String oikeaVastaus) {
        this.oikeaVastaus = oikeaVastaus;
    }

    public void setVaaratVastaukset(ArrayList<String> vaaratVastaukset) {
        for (String vaaraVastaus : vaaratVastaukset) {
            this.vaaratVastausvaihtoehdot.add(vaaraVastaus);
        }
    }

    public String getKysymyssana() {
        return this.kysymyssana;
    }

    public String getOikeaVastaus() {
        return this.oikeaVastaus;
    }

    public boolean onkoOikeaVastaus(String vastaus) {
        if (vastaus.toUpperCase().equals(getOikeaVastaus().toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getVaaratVastaukset() {
        return this.vaaratVastausvaihtoehdot;
    }
}
