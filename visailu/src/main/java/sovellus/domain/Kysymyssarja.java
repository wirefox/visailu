package sovellus.domain;

import java.util.ArrayList;

public class Kysymyssarja {

    private ArrayList<Kysymys> kysymykset;

    public Kysymyssarja() {
        this.kysymykset = new ArrayList<Kysymys>();
    }

    public void lisaaKysymys(Kysymys kysymys) {
        this.kysymykset.add(kysymys);
    }

    public Kysymys getKysymys(int i) {
        return this.kysymykset.get(i);
    }
}
