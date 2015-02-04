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

    public void lisaaKysymys(Kysymys kysymys) {
        this.kysymykset.add(kysymys);
    }

    public int getKysymystenLkm() {
        return this.kysymykset.size();
    }

    public Kysymys getKysymys(int i) {
        return this.kysymykset.get(i);
    }

    public Kysymys annaSeuraavaKysymys(int kierroksenNumero) {
        return this.kysymykset.get(kierroksenNumero);
    }

    public void sekoitaSarjanKysymykset() {
        Collections.shuffle(this.kysymykset);
    }
}
