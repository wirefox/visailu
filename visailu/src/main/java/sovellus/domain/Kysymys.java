package sovellus.domain;

import java.util.ArrayList;

/**
 * Luokassa luodaan pelin kysymykset; siinä on kysymyksen kysymyssanan, oikean
 * vastauksen ja väärien vastausten asetus ja näitä vastaavat getterit
 *
 * @author elina
 */
public class Kysymys {

    private String kysymyssana;
    private String oikeaVastaus;
    private ArrayList<String> vaaratVastausvaihtoehdot;

    public Kysymys() {
        this.vaaratVastausvaihtoehdot = new ArrayList<String>();
        this.kysymyssana = null;
        this.oikeaVastaus = null;
    }

    public void setKysymyssana(String kysymyssana) {
        this.kysymyssana = kysymyssana.toUpperCase();
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
        String vastausIsoilla = vastaus.toUpperCase();
        String oikeaVastausIsoilla = getOikeaVastaus().toUpperCase();
        if (vastausIsoilla.equals(oikeaVastausIsoilla)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getVaaratVastaukset() {
        return this.vaaratVastausvaihtoehdot;
    }
}
