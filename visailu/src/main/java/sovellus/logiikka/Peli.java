package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

/**
 * Luokassa on pelin pelaamisen toiminnallisuus.
 *
 * Luokassa on talletettuna kysymyssarja-olio, kierroksen kysymysolio ja pelin
 * kierroksen numero ja pelaajan pistetilanne.
 *
 * @author elina
 */
public class Peli {

    private Kysymyssarja kysymyssarja;
    private Kysymys kysymys;
    private int pisteitaPelaajalla;
    private int kierroksenNumero;

    public Peli(Kysymyssarja kysymyssarja) {
        this.kysymyssarja = kysymyssarja;
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 1;
    }

    /**
     * Metodissa pyydetään kysymyssarjaa vaihtamaan uudelle pelikierrokselle
     * seuraavan kysymysolion.
     */
    public void vaihdaSeuraavaKysymys() {
        this.kysymys = this.kysymyssarja.annaSeuraavaKysymys(this.kierroksenNumero - 1);
    }

    /**
     * Metodi tarkistaa jatketaanko peliä vai onko aika lopettaa.
     *
     * Pelissä on 10 kierrosta.
     *
     * @return boolean Palautetaan true, jos peliä jatketaan ja false, jos peliä
     * ei jatketa
     */
    public boolean jatketaankoPelia() {
        return getKierroksenNumero() < 11;
    }

    /**
     * Metodissa kasvatetaan kierroksen numeroa yhdellä.
     */
    public void kasvataKierroksenNumeroa() {
        this.kierroksenNumero++;
    }

    public void setPisteitaPelaajalla(int pisteitaPelaajalla) {
        this.pisteitaPelaajalla = pisteitaPelaajalla;
    }

    public Kysymys getKysymys() {
        return this.kysymys;
    }

    /**
     * Metodi antaa kierroksen kysymyslauseen.
     *
     * @return String
     */
    public String getKierroksenKysymyslause() {
        return this.kierroksenNumero + ": " + this.kysymyssarja.getKysymyslause();
    }

    /**
     * Metodissa muodostetaan kysymykselle vastausvaihtoehdot.
     *
     * Metodi kysyy oikean vastauksen ja väärät vaihtoehdot kysymysoliolta,
     * lisää ne listaan ja sekoittaa järjestyksen. Järjestys sekoitetaan, jotta
     * oikea vastaus ei olisi aina samassa kohtaa.
     *
     * @return vastausvaihtoehdot Palautetaan lista, jossa on vastausvaihtoehdot
     */
    public ArrayList<String> muodostaVastausvaihtoehdot() {
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
     * Metodissa arvioidaan pelaajan vastaus ja kasvatetaan tarvittaessa
     * pelaajan pistesaldoa.
     *
     * Metodi kysyy kysymysoliolta oikean vastauksen ja vertaa sitä pelaajan
     * vastaukseen. Pelaajan pistesaldoa kasvatetaan, jos pelaaja vastasi
     * oikein.
     *
     * @param vastaus Pelaajan vastaus kysymykseen
     * @return String palaute pelaajalle hänen vastauksestaan
     */
    public String vastauksenArviointi(String vastaus) {
        if (this.kysymys.onkoOikeaVastaus(vastaus)) {
            this.pisteitaPelaajalla++;
            return "Hienoa, oikea vastaus!";
        } else {
            return "Nyt meni väärin. Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus();
        }
    }

    /**
     * Metodi antaa pelin lopetustekstin, jonka sisältö riippuu pelaajan
     * pistesaldosta,
     *
     * @return String Lopetustekstinä pelaajalle palautetta hänen
     * onnistumisestaan
     */
    public String pelinLopetusteksti() {
        if (getPisteitaPelaajalla() == 10) {
            return "Game over! Olet loistava, kaikki oikein!";
        } else if (getPisteitaPelaajalla() >= 8) {
            return "Game over! Hieno suoritus!";
        } else if (getPisteitaPelaajalla() > 5) {
            return "Game over! Enemmän kuin puolet oikein!";
        } else {
            return "Game over! Vielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)";
        }
    }

    /**
     * Metodi tulostaa pelaajan pistetilanteen joka kierroksen lopussa.
     *
     * @return String Pelaajan pistetilannetulostus
     */
    public String pistetilanneTeksti() {
        return "Pisteesi: " + getPisteitaPelaajalla() + " / " + getKierroksenNumero();
    }
}
