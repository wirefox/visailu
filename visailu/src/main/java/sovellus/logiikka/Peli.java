package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

public class Peli {

    private Kysymyssarja kysymyssarja;
    private Kysymys kysymys;
    private String kysymyslause;
    private int pisteitaPelaajalla;
    private int kierroksenNumero;
    private Tekstikayttoliittyma tekstikayttoliittyma;

    public Peli(Kysymyssarja kysymyssarja, Tekstikayttoliittyma tekstikayttoliittyma) {
        this.kysymyssarja = kysymyssarja;
        this.tekstikayttoliittyma = tekstikayttoliittyma;
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 1;
    }

    public void pelaaKierros(String kysymyslause) {
        this.kysymyslause = kysymyslause;
        this.tekstikayttoliittyma.tulosta(annaKierroksenKysymyslause());
        this.kysymys = this.kysymyssarja.arvoKysymys();
        this.tekstikayttoliittyma.tulosta(annaKysymyssana());

        this.tekstikayttoliittyma.tulostaVastausvaihtoehdot(annaVastausvaihtoehdot());

        String vastaus = this.tekstikayttoliittyma.otaVastaus("\nKirjoita arvauksesi: ");
        this.tekstikayttoliittyma.tulosta(vastauksenArviointi(vastaus));

        this.tekstikayttoliittyma.tulosta(pistetilanteenTulostus());
        this.kierroksenNumero++;
    }

    public boolean onkoVikaKierros() {
        if (getKierroksenNumero() > 20) {
            return true;
        } else {
            return false;
        }
    }

    public int getKierroksenNumero() {
        return this.kierroksenNumero;
    }

    public int getPisteitaPelaajalla() {
        return this.pisteitaPelaajalla;
    }

    private ArrayList<String> annaVastausvaihtoehdot() {
        ArrayList<String> vastausvaihtoehdot = this.kysymys.getVaaratVastaukset();
        vastausvaihtoehdot.add(this.kysymys.getOikeaVastaus());
        Collections.shuffle(vastausvaihtoehdot);
        return vastausvaihtoehdot;
    }

    private String vastauksenArviointi(String vastaus) {
        if (vastaus.toUpperCase().equals(this.kysymys.getOikeaVastaus().toUpperCase())) {
            this.pisteitaPelaajalla++;
            return "Hienoa, oikea vastaus!";
        } else {
            return "Nyt meni väärin. Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus();
        }
    }

    private String pistetilanteenTulostus() {
        return "\nPisteesi: " + this.pisteitaPelaajalla + " / " + getKierroksenNumero() + "\n";
    }

    private String annaKierroksenKysymyslause() {
        return this.kierroksenNumero + ": " + this.kysymyslause;
    }

    private String annaKysymyssana() {
        return this.kysymys.getKysymyssana().toUpperCase();
    }
}