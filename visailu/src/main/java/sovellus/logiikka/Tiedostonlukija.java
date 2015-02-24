package sovellus.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokasta luotu tiedostonlukija-olio lukee sisään tiedoston.
 *
 * Visan kysymyslause ja kysymys-vastaus parin talletetaan.
 *
 * @author elina
 */
public class Tiedostonlukija {

    private Scanner lukija;
    private HashMap<String, String> kysymysJaVastaus;
    private String kysymyslause;

    public Tiedostonlukija() {
        this.kysymysJaVastaus = new HashMap<String, String>();
    }

    /**
     * Metodissa luetaan sisään tiedosto ja muodostetaan siitä kysymys-vastaus
     * -HashMap.
     *
     * Metodi kutsuu muokkaaLuettuaTekstiaJaTalleta()-metodia, jolle vastuuta on
     * jaettu.
     *
     * @param tiedostonnimi Metodi saa parametrina luettavan tiedoston nimen.
     * @return this.kysymysJaVastaus Metodi palauttaa HashMapin, jossa on
     * tallennettuna kysymys-vastaus -parit.
     */
    public HashMap<String, String> lueTiedosto(String tiedostonnimi) {
        File tiedosto = new File(tiedostonnimi);

        try {
            this.lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tiedostonlukija.class.getName()).log(Level.SEVERE, null, ex);
        }

        muokkaaLuettuaTekstiaJaTalleta();
        return this.kysymysJaVastaus;
    }

    /**
     * Metodissa luetaan tiedostoa, ositetaan/pilkotaan luettujen rivien teksti
     * ja talletetaan HashMapiin.
     */
    private void muokkaaLuettuaTekstiaJaTalleta() {
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
