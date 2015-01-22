package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Vastausarpoja {

    public ArrayList<String> arvoVastauksetKysymykselle(ArrayList<String> listaVastauksia) {
        ArrayList<String> vastaukset = new ArrayList<String>();

        //arvotaan yhdelle kysymykselle neljä väärää vastausvaihtoehtoa
        for (int i = 0; vastaukset.size() < 4; i++) {
            Random arpoja = new Random();
            int vastauksenNro = arpoja.nextInt(listaVastauksia.size());
            String vastaus = listaVastauksia.get(vastauksenNro);

            if (!vastaukset.contains(vastaus)) {
                vastaukset.add(vastaus);
            }
        }
        return vastaukset;
    }
}
