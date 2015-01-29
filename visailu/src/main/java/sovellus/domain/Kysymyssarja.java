package sovellus.domain;

import java.util.ArrayList;
import java.util.Random;

public class Kysymyssarja {

    private ArrayList<Kysymys> kysymykset;
    private Random arpoja;
    private ArrayList<Integer> arvotutKysymyksenNumerot;

    public Kysymyssarja() {
        this.kysymykset = new ArrayList<Kysymys>();
        this.arpoja = new Random();
        this.arvotutKysymyksenNumerot = new ArrayList<Integer>();
    }

    public void lisaaKysymys(Kysymys kysymys) {
        this.kysymykset.add(kysymys);
    }

    public int getKysymystenLkm() {
        return this.kysymykset.size();
    }

// pitäisikö kysymysten arpominen olla erillisessä Kysymysarpoja-luokassa??!?    
    public Kysymys arvoKysymys() {
        int kysymyksenNumero = this.arpoja.nextInt(this.kysymykset.size());
        while (true) {
            if (!this.arvotutKysymyksenNumerot.contains(kysymyksenNumero)) {
                this.arvotutKysymyksenNumerot.add(kysymyksenNumero);
                return this.kysymykset.get(kysymyksenNumero);
            } else {
                continue;
            }
        }
    }
}
