package sovellus.logiikka;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;

public class VastausarpojaTest {

    private ArrayList<String> vastauksia;
    private VastausvaihtoehtoArpoja vastausarpoja;
    private Kysymys kysymys;
    private ArrayList<String> vaaratVastaukset;

    public VastausarpojaTest() {
    }

    @Before
    public void setUp() {
        this.kysymys = new Kysymys();
        this.kysymys.setKysymyssana("Espanja");
        this.kysymys.setOikeaVastaus("Madrid");
        this.vastauksia = new ArrayList<>();
        vastauksia.add("Helsinki");
        vastauksia.add("Tukholma");
        vastauksia.add("Tallinna");
        vastauksia.add("Madrid");
        vastauksia.add("Lissabon");
        vastauksia.add("Pariisi");
        vastauksia.add("Berliini");
        vastauksia.add("Praha");
        vastauksia.add("Peking");
        this.vastausarpoja = new VastausvaihtoehtoArpoja();

        this.vaaratVastaukset = new ArrayList<>();
        vaaratVastaukset = this.vastausarpoja.arvoVastausvaihtoehdotKysymykselle(this.vastauksia, this.kysymys);
    }

    @Test
    public void vastausarpojaArpooNeljaVaaraaVastausta() {
        assertEquals(4, vaaratVastaukset.size());
    }

    @Test
    public void vastausarpojaEiArvoVastaukseksiOikeaaVastausta() {

        Boolean onkoOikeaVastausJoukossa = false;

        if (vaaratVastaukset.contains(this.kysymys.getOikeaVastaus())) {
            onkoOikeaVastausJoukossa = true;
        }

        assertFalse(onkoOikeaVastausJoukossa);
    }
}
