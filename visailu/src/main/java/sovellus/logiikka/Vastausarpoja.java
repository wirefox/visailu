package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Random;
import sovellus.domain.Kysymys;

/**
 * Luokka arpoo pelikierroksen kysymykselle listan vääriä vastausvaihtoehtoja
 */
public class Vastausarpoja {

    private Kysymys kysymys;

    public Vastausarpoja(Kysymys kysymys) {
        this.kysymys = kysymys;
    }

    public ArrayList<String> arvoVastauksetKysymykselle(ArrayList<String> listaVastauksia) {
        ArrayList<String> vastaukset = new ArrayList<String>();

        for (int i = 0; vastaukset.size() < 4; i++) {
            Random arpoja = new Random();
            int vastauksenNro = arpoja.nextInt(listaVastauksia.size());
            String vastaus = listaVastauksia.get(vastauksenNro);

            if (!vastaukset.contains(vastaus) && !this.kysymys.getOikeaVastaus().equals(vastaus)) {
                vastaukset.add(vastaus);
            }
        }
        return vastaukset;
    }
}
