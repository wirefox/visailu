package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

/**
 * Luokassa pelataan peliä; siinä on talletettuna pelin kierroksen numero ja
 * pelaajan pistetilanne Tätä kuvausta tarkennettava
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

    public void vaihdaSeuraavaKysymys() {
        this.kysymys = this.kysymyssarja.annaSeuraavaKysymys(this.kierroksenNumero);
    }

    public boolean onkoVikaKierros() {
        if (getKierroksenNumero() >= 20) {
            return true;
        } else {
            return false;
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
        System.out.println(this.kysymys.getOikeaVastaus());  // oikea vastaus on null testeissä, mutta näin ei ole luokassa!??!!
        if (this.kysymys.onkoOikeaVastaus(vastaus)) {
            setPisteitaPelaajalla(getPisteitaPelaajalla() + 1);
            return "Hienoa, oikea vastaus!";
        } else {
            return "Nyt meni väärin. Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus();
        }
    }

    public String pelinLopetusteksti() {
        if (getPisteitaPelaajalla() == 20) {
            return "\nOlet loistava, kaikki oikein!";
        } else if (getPisteitaPelaajalla() > 15) {
            return "\nHieno suoritus!";
        } else if (getPisteitaPelaajalla() > 10) {
            return "\nEnemmän kuin puolet oikein!";
        } else if (getPisteitaPelaajalla() == 10) {
            return "\nPuolet oikein!";
        } else if (getPisteitaPelaajalla() < 10) {
            return "\nVielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)";
        }
        return null;
    }

    public String pistetilanteenTulostus() {
        return "\nPisteesi: " + this.pisteitaPelaajalla + " / " + getKierroksenNumero() + "\n";
    }
}
