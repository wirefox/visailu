package sovellus.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KysymyssarjaTest {

    private ArrayList<Kysymys> kysymykset;

    public KysymyssarjaTest() {
        this.kysymykset = new ArrayList<Kysymys>();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Kysymys kysymys = new Kysymys();
        kysymys.lisaaKysymyssana("Espanja");
        kysymys.lisaaOikeaVastaus("Madrid");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        kysymys.lisaaVaaratVastaukset(vaaratVastaukset);

        this.kysymykset.add(kysymys);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kysymyksenLisaamisenJalkeenListanKokoOnYksi() {
        assertEquals(1, this.kysymykset.size());
    }
    
    @Test
    public void kysymyssarjastaEiArvotaListanEnsimmäistä() {
        
    }
}
