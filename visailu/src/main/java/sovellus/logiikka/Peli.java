package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import sovellus.domain.Kysymys;
import sovellus.gui.Tekstikayttoliittyma;

public class Peli {

    private Tekstikayttoliittyma tekstikayttoliittyma;
    private String kysymyslause;
    private Kysymys kysymys;
    private int pisteitaPelaajalla;
    private int kierroksenNumero;

    public Peli(Tekstikayttoliittyma tekstikayttoliittyma, String kysymyslause) {
        this.tekstikayttoliittyma = tekstikayttoliittyma;
        this.kysymyslause = kysymyslause;
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 0;
    }

    public void pelaaKierros(Kysymys kysymys) {
        this.kysymys = kysymys;
        this.tekstikayttoliittyma.tulostaNaytolle(annaKierroksenKysymyslause());
        this.tekstikayttoliittyma.tulostaNaytolle(annaKysymyssana());
        this.tekstikayttoliittyma.tulostaNaytolle(annaVastausvaihtoehdot());
        String vastaus = this.tekstikayttoliittyma.otaVastaus("\nKirjoita arvauksesi: ");
        this.tekstikayttoliittyma.tulostaNaytolle(vastauksenArviointi(vastaus));
        this.tekstikayttoliittyma.tulostaNaytolle(pistetilanteenTulostus());
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

    public ArrayList<String> annaVastausvaihtoehdot() {
        ArrayList<String> vastausvaihtoehdot = this.kysymys.getVaaratVastaukset();
        vastausvaihtoehdot.add(this.kysymys.getOikeaVastaus());
        Collections.shuffle(vastausvaihtoehdot);
        return vastausvaihtoehdot;
    }

    public String vastauksenArviointi(String vastaus) {
        if (vastaus.toUpperCase().equals(this.kysymys.getOikeaVastaus().toUpperCase())) {
            this.pisteitaPelaajalla++;
            return "Hienoa, oikea vastaus!";
        } else {
            return "Nyt meni väärin. Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus();
        }
    }

    public String pistetilanteenTulostus() {
        return "\nPisteesi: " + this.pisteitaPelaajalla + " / " + getKierroksenNumero() + "\n";
    }

    public String annaKierroksenKysymyslause() {
        this.kierroksenNumero++;
        return this.kierroksenNumero + ": " + this.kysymyslause;
    }

    public String annaKysymyssana() {
        return this.kysymys.getKysymyssana().toUpperCase();
    }
}