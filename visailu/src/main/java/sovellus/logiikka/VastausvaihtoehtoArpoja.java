package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Random;
import sovellus.domain.Kysymys;

//KOrjausehdotus: luokan ja metodin nimet!
/**
 * Luokka arpoo pelikierroksen kysymykselle listan vääriä vastausvaihtoehtoja
 *
 * @author elina
 */
public class Vastausarpoja {

    /**
     * Metodissa arvotaan neljä väärää vastausvaihtoehtoa kysymykselle.
     *
     * @param listaVastauksia metodi saa parametrina listan, jossa on kaikki
     * mahdolliset vastaukset
     * @param kysymys metodi saa parametrina pelikierroksen kysymyksen, jotta se
     * ei arpoisi oikeaa vastausta väärien vastausvaihtoehtojen joukkoon
     * @return vastaukset metodi palauttaa listan, jossa on väärät
     * vastausvaihtoehdot
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
