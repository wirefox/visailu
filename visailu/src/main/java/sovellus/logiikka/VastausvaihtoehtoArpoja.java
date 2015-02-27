package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Random;
import sovellus.domain.Kysymys;

/**
 * Luokka arpoo kysymysoliolle listan (4 kpl) vääriä vastausvaihtoehtoja.
 *
 * @author elina
 */
public class VastausvaihtoehtoArpoja {

    private Random arpoja;

    /**
     * Konstruktori luo uuden vastausvaihtoehtoArpoja-olion ja random-olion.
     */
    public VastausvaihtoehtoArpoja() {
        this.arpoja = new Random();
    }

    /**
     * Metodissa arvotaan neljä väärää vastausvaihtoehtoa kysymysoliolle.
     *
     * @param listaVastauksia Metodi saa parametrina listan, jossa on kaikki
     * mahdolliset vastaukset.
     * @param kysymys Metodi saa parametrina pelikierroksen kysymysolion, jotta
     * se ei tietää olla arpomatta oikeaa vastausta väärien vastausvaihtoehtojen
     * joukkoon.
     * @return vastaukset Metodi palauttaa listan, jossa on väärät
     * vastausvaihtoehdot.
     */
    public ArrayList<String> arvoVastausvaihtoehdotKysymykselle(ArrayList<String> listaVastauksia, Kysymys kysymys) {
        ArrayList<String> vastaukset = new ArrayList<>();

        for (int i = 0; vastaukset.size() < 4; i++) {
            int vastauksenNro = this.arpoja.nextInt(listaVastauksia.size());
            String vastaus = listaVastauksia.get(vastauksenNro);

            if (!vastaukset.contains(vastaus) && !kysymys.getOikeaVastaus().equals(vastaus)) {
                vastaukset.add(vastaus);
            }
        }
        return vastaukset;
    }
}
