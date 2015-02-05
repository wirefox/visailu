package sovellus.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka lukee sisään tiedoston ja tallettaa siitä visan kysymyslauseen sekä
 * kysymys-vastaus -parin
 */

public class Tiedostonlukija {

    private Scanner lukija;
    private HashMap<String, String> kysymysJaVastaus;
    private String kysymyslause;

    public Tiedostonlukija() {
        this.kysymysJaVastaus = new HashMap<String, String>();
    }

    public HashMap<String, String> lueTiedosto(String tiedostonnimi) {
        File tiedosto = new File(tiedostonnimi);

        try {
            this.lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tiedostonlukija.class.getName()).log(Level.SEVERE, null, ex);
        }

        ositaTiedostostaLuettuTekstiJaTalleta();
        return this.kysymysJaVastaus;
    }

    private void ositaTiedostostaLuettuTekstiJaTalleta() {
        this.kysymyslause = lukija.nextLine();

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(",");
            String osa1 = osat[0];
            String osa2 = osat[1];
            this.kysymysJaVastaus.put(osa1, osa2);
        }
    }

    public String getKysymyslause() {
        return this.kysymyslause;
    }
}
