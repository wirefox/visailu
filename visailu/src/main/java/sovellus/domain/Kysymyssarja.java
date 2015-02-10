package sovellus.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Luokka tallettaa kysymykset listaan, sekoittaa listan, ja antaa visan
 * seuraavan kysymyksen
 *
 * @author elina
 */
public class Kysymyssarja {

    private ArrayList<Kysymys> kysymykset;
    String kysymyslause;

    public Kysymyssarja(String kysymyslause) {
        this.kysymykset = new ArrayList<Kysymys>();
        this.kysymyslause = kysymyslause;
    }

    /**
     * Metodi lisää sille parametrina annetun kysymyksen listalle
     *
     * @param kysymys saa kysymyksen, jonka lisää listalle
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
     * Metodi antaa kysymyslistalta seuraavan kysymyksen
     *
     * @param kierroksenNumero saa kierroksen numeron, joka määrää mistä
     * kohdasta listaa kysymys otetaan
     * @return kysymys palauttaa seuraavan kysymyksen
     */
    public Kysymys annaSeuraavaKysymys(int kierroksenNumero) {
        Kysymys kysymys = this.kysymykset.get(kierroksenNumero);
        return kysymys;
    }

    /**
     * Metodi sekoittaa kysymyslistan
     *
     * Sekoitus tehdään, jossa kysymyksen eivät tulisi joka pelissä samassa
     * järjestyksessä
     */
    public void sekoitaSarjanKysymykset() {
        Collections.shuffle(this.kysymykset);
    }

    public String getKysymyslause() {
        return this.kysymyslause;
    }
}
