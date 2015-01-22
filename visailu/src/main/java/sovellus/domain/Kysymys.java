package sovellus.domain;

import java.util.ArrayList;

public class Kysymys {

    private Kysymyssarja kysymyssarja;
    private String kysymyssana;
    private String oikeaVastaus;
    private ArrayList<String> vaaratVastausvaihtoehdot;

    public Kysymys() {
        this.vaaratVastausvaihtoehdot = new ArrayList<String>();
    }

    public void lisaaKysymyssana(String kysymyssana) {
        this.kysymyssana = kysymyssana;
    }

    public void lisaaOikeaVastaus(String oikeaVastaus) {
        this.oikeaVastaus = oikeaVastaus;
    }

    public void lisaaVaaratVastaukset(ArrayList<String> vaaratVastaukset) {
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

    public ArrayList<String> getVaaratVastaukset() {
        return this.vaaratVastausvaihtoehdot;
    }
}
