package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Random;
import sovellus.domain.Kysymys;

/**
 * Luokka arpoo pelikierroksen kysymykselle listan vääriä vastausvaihtoehtoja
 *
 * @author elina
 */
public class Vastausarpoja {

    /**
     * Metodi
     */
    public ArrayList<String> arvoVastauksetKysymykselle(ArrayList<String> listaVastauksia, Kysymys kysymys) {
        ArrayList<String> vastaukset = new ArrayList<String>();

        for (int i = 0; vastaukset.size() < 4; i++) {
            Random arpoja = new Random();
            int vastauksenNro = arpoja.nextInt(listaVastauksia.size());
            String vastaus = listaVastauksia.get(vastauksenNro);

            if (!vastaukset.contains(vastaus) && !kysymys.getOikeaVastaus().equals(vastaus)) {
                vastaukset.add(vastaus);
            }
        }
        return vastaukset;
    }
}
