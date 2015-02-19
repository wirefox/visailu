package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Random;
import sovellus.domain.Kysymys;

//Korjausehdotus: luokan ja metodin nimet!
/**
 * Luokka arpoo pelikierroksen kysymysoliolle listan vääriä vastausvaihtoehtoja
 *
 * @author elina
 */
public class VastausvaihtoehtoArpoja {

    private Random arpoja;

    public VastausvaihtoehtoArpoja() {
        this.arpoja = new Random();
    }

    /**
     * Metodissa arvotaan neljä väärää vastausvaihtoehtoa kysymysoliolle.
     *
     * @param listaVastauksia metodi saa parametrina listan, jossa on kaikki
     * mahdolliset vastaukset
     * @param kysymys metodi saa parametrina pelikierroksen kysymysolion, jotta
     * se ei arpoisi oikeaa vastausta väärien vastausvaihtoehtojen joukkoon
     * @return vastaukset metodi palauttaa listan, jossa on väärät
     * vastausvaihtoehdot
     */
    public ArrayList<String> arvoVastausvaihtoehdotKysymykselle(ArrayList<String> listaVastauksia, Kysymys kysymys) {
        ArrayList<String> vastaukset = new ArrayList<String>();

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
