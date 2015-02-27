package sovellus.domain;

import java.util.ArrayList;

/**
 * Luokka luo pelin kysymykset.
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

    /**
     * Konstruktori luo kysymysolion ja sille väärien vastausvaihtoehtojen
     * listan.
     *
     */
    public Kysymys() {
        this.vaaratVastausvaihtoehdot = new ArrayList<>();
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
     * @param vaaratVastaukset Lista, jossa neljä väärää vastausta.
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
     * Metodi tarkistaa onko vastaus oikein.
     *
     * @param vastaus String, jossa pelaajan vastaus kysymykseen.
     * @return boolean Palautetaan true, jos oikea vastaus ja false, jos väärä.
     */
    public boolean onkoOikeaVastaus(String vastaus) {
        return vastaus.equals(getOikeaVastaus());
    }

    public ArrayList<String> getVaaratVastaukset() {
        return this.vaaratVastausvaihtoehdot;
    }
}
