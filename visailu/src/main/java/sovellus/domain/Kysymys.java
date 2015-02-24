package sovellus.domain;

import java.util.ArrayList;

/**
 * Luokassa luodaan pelin kysymykset.
 *
 * Kysymysolioilla on talletettuna niiden kysymyssana, oikea vastaus ja väärät
 * vastaukset.
 *
 * @author elina
 */
public class Kysymys {

    private String kysymyssana;
    private String oikeaVastaus;
    private ArrayList<String> vaaratVastausvaihtoehdot;

    public Kysymys() {
        this.vaaratVastausvaihtoehdot = new ArrayList<String>();
    }

    public void setKysymyssana(String kysymyssana) {
        this.kysymyssana = kysymyssana;
    }

    public void setOikeaVastaus(String oikeaVastaus) {
        this.oikeaVastaus = oikeaVastaus;
    }

    /**
     * Metodi lisää kysymykselle neljä väärää vastausta.
     *
     * @param vaaratVastaukset lista, jossa neljä väärää vastausta
     */
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

    /**
     * Metodi tarkistaa onko vastaus oikein
     *
     * @param vastaus string, jossa pelaajan vastaus kysymykseen
     * @return boolean palautetaan true, jos oikea vastaus ja false, jos väärä
     */
    public boolean onkoOikeaVastaus(String vastaus) {
        if (vastaus.equals(getOikeaVastaus())) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getVaaratVastaukset() {
        return this.vaaratVastausvaihtoehdot;
    }
}
