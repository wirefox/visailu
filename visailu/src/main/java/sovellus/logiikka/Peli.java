package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.SwingUtilities;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.GraafinenKayttoliittyma;
import sovellus.gui.Tekstikayttoliittyma;

/**
 * Luokassa on pelin pelaamisen toiminnallisuus ja siinä on talletettuna pelin
 * kierroksen numero ja pelaajan pistetilanne
 *
 * @author elina
 */
public class Peli {

    private Tekstikayttoliittyma tekstikayttoliittyma;
    private Kysymyssarja kysymyssarja;
    private Kysymys kysymys;
    private int pisteitaPelaajalla;
    private int kierroksenNumero;

    public Peli(String kysymyslause, Kysymyssarja kysymyssarja) {
        this.kysymyssarja = kysymyssarja;
        this.kysymys = new Kysymys();
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 0;
    }

    /**
     * Metodi
     */
    public void pelaaPeli() {
        GraafinenKayttoliittyma graafinenKayttoliittyma = new GraafinenKayttoliittyma(this);
        SwingUtilities.invokeLater(graafinenKayttoliittyma);
 //       Tekstikayttoliittyma tekstikayttoliittyma = new Tekstikayttoliittyma(this);
        pelinLopetusteksti();
    }

    /**
     * Metodi vaihtaa uudelle pelikierrokselle uuden kysymyksen
     */
    public void vaihdaSeuraavaKysymys() {
        this.kysymys = this.kysymyssarja.annaSeuraavaKysymys(this.kierroksenNumero);
    }

    /**
     * Metodi
     */
    public boolean jatketaankoPelia() {
        if (getKierroksenNumero() >= 10) {
            return false;
        } else {
            return true;
        }
    }

    public void setKierroksenNumero(int kierroksenNumero) {
        this.kierroksenNumero = kierroksenNumero;
    }

    public void setPisteitaPelaajalla(int pisteitaPelaajalla) {
        this.pisteitaPelaajalla = pisteitaPelaajalla;
    }

    public Kysymys getKysymys() {
        return this.kysymys;
    }

    public String getKierroksenKysymyslause() {
        return this.kierroksenNumero + 1 + ": " + this.kysymyssarja.getKysymyslause();
    }

    /**
     * Metodi
     */
    public ArrayList<String> getVastausvaihtoehdot() {
        ArrayList<String> vastausvaihtoehdot = this.kysymys.getVaaratVastaukset();
        vastausvaihtoehdot.add(this.kysymys.getOikeaVastaus());
        Collections.shuffle(vastausvaihtoehdot);
        return vastausvaihtoehdot;
    }

    public int getKierroksenNumero() {
        return this.kierroksenNumero;
    }

    public int getPisteitaPelaajalla() {
        return this.pisteitaPelaajalla;
    }

    /**
     * Metodi
     */
    public String vastauksenArviointi(String vastaus) {
        setKierroksenNumero(getKierroksenNumero() + 1);
        if (this.kysymys.onkoOikeaVastaus(vastaus)) {
            setPisteitaPelaajalla(getPisteitaPelaajalla() + 1);
            return "Hienoa, oikea vastaus!";
        } else {
            return "Nyt meni väärin. Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus();
        }
    }

    /**
     * Metodi
     */
    public String pelinLopetusteksti() {
        if (getPisteitaPelaajalla() == 10) {
            return "\nOlet loistava, kaikki oikein!";
        } else if (getPisteitaPelaajalla() >= 8) {
            return "\nHieno suoritus!";
        } else if (getPisteitaPelaajalla() > 5) {
            return "\nEnemmän kuin puolet oikein!";
        } else {
            return "\nVielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)";
        }
    }

    /**
     * Metodi
     */
    public String pistetilanteenTulostus() {
        return "\nPisteesi: " + this.pisteitaPelaajalla + " / " + getKierroksenNumero() + "\n";
    }
}
