package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

/**
 * Luokassa on pelin pelaamisen toiminnallisuus 
 * ja siinä on talletettuna pelin kierroksen numero 
 * ja pelaajan pistetilanne
 */

public class Peli {

    private Tekstikayttoliittyma tekstikayttoliittyma;
    private String kysymyslause;
    private Kysymyssarja kysymyssarja;
    private Kysymys kysymys;
    private int pisteitaPelaajalla;
    private int kierroksenNumero;

    public Peli(String kysymyslause, Kysymyssarja kysymyssarja) {
        this.kysymyslause = kysymyslause;
        this.kysymyssarja = kysymyssarja;
        this.kysymys = new Kysymys();
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 0;
    }

    public void pelaaPeli() {
        Tekstikayttoliittyma tekstikayttoliittyma = new Tekstikayttoliittyma(this);
        pelinLopetusteksti();
    }

    /**
     * Metodi vaihtaa uudelle pelikierrokselle uuden kysymyksen
     */
    public void vaihdaSeuraavaKysymys() {
        this.kysymys = this.kysymyssarja.annaSeuraavaKysymys(this.kierroksenNumero);
    }

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
        return this.kierroksenNumero + 1 + ": " + this.kysymyslause;
    }

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

    public String vastauksenArviointi(String vastaus) {
        setKierroksenNumero(getKierroksenNumero() + 1);
        if (this.kysymys.onkoOikeaVastaus(vastaus)) {
            setPisteitaPelaajalla(getPisteitaPelaajalla() + 1);
            return "Hienoa, oikea vastaus!";
        } else {
            return "Nyt meni väärin. Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus();
        }
    }

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

    public String pistetilanteenTulostus() {
        return "\nPisteesi: " + this.pisteitaPelaajalla + " / " + getKierroksenNumero() + "\n";
    }
}
