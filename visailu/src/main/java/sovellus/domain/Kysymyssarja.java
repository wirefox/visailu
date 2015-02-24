package sovellus.domain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka tallettaa kysymysoliot listaan, sekoittaa listan, ja antaa visan
 * seuraavan kysymysolion.
 *
 * @author elina
 */
public class Kysymyssarja {

    private ArrayList<Kysymys> kysymykset;
    private String kysymyslause;

    public Kysymyssarja(String kysymyslause) {
        this.kysymykset = new ArrayList<Kysymys>();
        this.kysymyslause = kysymyslause;
    }

    /**
     * Metodi lisää sille parametrina annetun kysymysolion listalle
     *
     * @param kysymys saa kysymysolion, jonka lisää listalle
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

    public String getKysymyslause() {
        return this.kysymyslause;
    }

    /**
     * Metodi antaa kysymyslistalta seuraavan kysymysolion
     *
     * @param kierroksenNumero saa kierroksen numeron, joka määrää mistä
     * kohdasta listaa kysymysolio otetaan
     * @return kysymys palauttaa seuraavan kysymysolion
     */
    public Kysymys annaSeuraavaKysymys(int kierroksenNumero) {
        Kysymys kysymys = this.kysymykset.get(kierroksenNumero);
        return kysymys;
    }

    /**
     * Metodi sekoittaa kysymyslistan
     *
     * Sekoitus tehdään, jossa kysymysoliot eivät tulisi joka pelissä samassa
     * järjestyksessä
     */
    public void sekoitaSarjanKysymykset() {
        Collections.shuffle(this.kysymykset);
    }
}
