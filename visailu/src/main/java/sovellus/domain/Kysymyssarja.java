package sovellus.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Luokka tallettaa kysymykset listaan, sekoittaa listan, ja antaa visan
 * seuraavan kysymyksen
 */

public class Kysymyssarja {

    private ArrayList<Kysymys> kysymykset;

    public Kysymyssarja() {
        this.kysymykset = new ArrayList<Kysymys>();
    }

    /**
     * Metodi lisää sille parametrina annetun kysymyksen ArrayListiin
     */
    public void lisaaKysymys(Kysymys kysymys) {
        this.kysymykset.add(kysymys);
    }

    public int getKysymystenLkm() {
        return this.kysymykset.size();
    }

    public Kysymys getKysymys(int i) {
        return this.kysymykset.get(i);
    }

    /**
     * Metodi antaa kysymyslistalta seuraavan kysymyksen;
     * parametrina se saa pelin kierroksen numeron
     */
    public Kysymys annaSeuraavaKysymys(int kierroksenNumero) {
        return this.kysymykset.get(kierroksenNumero);
    }

    /**
     * Metodi sekoittaa kysymyslistan, jotta kysymykset eivät tule pelissä 
     * aina samassa järjestyksessä
     */
    public void sekoitaSarjanKysymykset() {
        Collections.shuffle(this.kysymykset);
    }
}
