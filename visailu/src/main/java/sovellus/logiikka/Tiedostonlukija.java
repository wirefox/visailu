package sovellus.logiikka;

import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokassa luetaan sisään pelin tarvitsema tiedosto.
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
        this.kysymysJaVastaus = new HashMap<>();
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
     * talletettuna kysymys-vastaus -parit.
     */
    public HashMap<String, String> lueTiedosto(String tiedostonnimi) {
        InputStream teksti = this.getClass().getResourceAsStream("/" + tiedostonnimi);

        try {
            this.lukija = new Scanner(teksti);
        } catch (InputMismatchException ip) {
            Logger.getLogger(Tiedostonlukija.class.getName()).log(Level.SEVERE, null, ip);
        }

        lueTekstiaJaTalleta();
        return this.kysymysJaVastaus;
    }

    /**
     * Metodissa luetaan tekstiä, ositetaan/pilkotaan luettujen rivien teksti ja
     * talletetaan HashMapiin.
     */
    private void lueTekstiaJaTalleta() {
        setKysymyslause(lukija.nextLine());

        while (this.lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(",");
            String osa1 = osat[0];
            String osa2 = osat[1];
            this.kysymysJaVastaus.put(osa1, osa2);
        }

        this.lukija.close();
    }

    public String getKysymyslause() {
        return this.kysymyslause;
    }

    public void setKysymyslause(String kysymyslause) {
        this.kysymyslause = kysymyslause;
    }
}
