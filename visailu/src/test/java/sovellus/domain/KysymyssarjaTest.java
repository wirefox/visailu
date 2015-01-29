package sovellus.domain;

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KysymyssarjaTest {

    private Kysymys kysymys;
    private Kysymyssarja kysymyssarja;
    private Random arpoja;
    private ArrayList<Integer> arvotutKysymyksenNumerot;

    public KysymyssarjaTest() {
        this.kysymyssarja = new Kysymyssarja();
        this.arpoja = new Random();
        this.arvotutKysymyksenNumerot = new ArrayList<Integer>();
        this.kysymys = new Kysymys();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.kysymys.lisaaKysymyssana("Espanja");
        this.kysymys.lisaaOikeaVastaus("Madrid");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        kysymys.lisaaVaaratVastaukset(vaaratVastaukset);

        this.kysymyssarja.lisaaKysymys(kysymys);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kysymyksenLisaamisenJalkeenListanKokoOnYksi() {
        assertEquals(1, this.kysymyssarja.getKysymystenLkm());
    }

    @Test
    public void kysymyssarjastaArpominenToimiiKunListassaYksiKysymys() {
        assertEquals(this.kysymys, this.kysymyssarja.arvoKysymys());
    }
}
