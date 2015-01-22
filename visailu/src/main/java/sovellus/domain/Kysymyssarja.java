package sovellus.domain;

import java.util.ArrayList;

public class Kysymyssarja {

    private ArrayList<Kysymys> kysymykset;

    public Kysymyssarja() {
        this.kysymykset = new ArrayList<Kysymys>();
        System.out.println("TESTI1");
    }

    public void lisaaKysymys(Kysymys kysymys) {
        System.out.println("TESTI2");
        this.kysymykset.add(kysymys);
    }

    public Kysymys getKysymys(int i) {
        return this.kysymykset.get(i);
    }
}
