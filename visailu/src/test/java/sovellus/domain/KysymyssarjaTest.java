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

    private Kysymys kysymys1;
    private Kysymys kysymys2;
    private Kysymyssarja kysymyssarja1;
    private Kysymyssarja kysymyssarja2;
    private Random arpoja;
    private ArrayList<Integer> arvotutKysymyksenNumerot;

    public KysymyssarjaTest() {
        this.kysymyssarja1 = new Kysymyssarja();
        this.kysymyssarja2 = new Kysymyssarja();
        this.arpoja = new Random();
        this.arvotutKysymyksenNumerot = new ArrayList<Integer>();
        this.kysymys1 = new Kysymys();
        this.kysymys2 = new Kysymys();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.kysymys1.lisaaKysymyssana("Espanja");
        this.kysymys1.lisaaOikeaVastaus("Madrid");

        this.kysymys2.lisaaKysymyssana("Thaimaa");
        this.kysymys2.lisaaOikeaVastaus("Bangkok");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        this.kysymys1.lisaaVaaratVastaukset(vaaratVastaukset);
        this.kysymys2.lisaaVaaratVastaukset(vaaratVastaukset);

        this.kysymyssarja1.lisaaKysymys(kysymys1);

        this.kysymyssarja2.lisaaKysymys(kysymys1);
        this.kysymyssarja2.lisaaKysymys(kysymys2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kysymyksenLisaamisenJalkeenListanKokoOnYksi() {
        assertEquals(1, this.kysymyssarja1.getKysymystenLkm());
    }

    @Test
    public void kahdenKysymyksenLisaamisenJalkeenListanKokoOnKaksi() {
        assertEquals(2, this.kysymyssarja2.getKysymystenLkm());
    }

    @Test
    public void kysymyslistallaOnOikeatKaksiKysymysta() {
        ArrayList<Kysymys> kysymyksetListalla = new ArrayList<Kysymys>();
        kysymyksetListalla.add(kysymys1);
        kysymyksetListalla.add(kysymys2);
        assertEquals(kysymyksetListalla.get(0), this.kysymyssarja2.getKysymys(0));
        assertEquals(kysymyksetListalla.get(1), this.kysymyssarja2.getKysymys(1));
    }

    @Test
    public void kysymyssarjastaArpominenToimiiKunListassaYksiKysymys() {
        assertEquals(this.kysymys1, this.kysymyssarja1.arvoKysymys());
    }

    @Test
    public void kysymyssarjastaArpominenToimiiKunListassaKaksiKysymysta() {
        Kysymys k1 = this.kysymyssarja2.arvoKysymys();
        Kysymys k2 = this.kysymyssarja2.arvoKysymys();

        assertNotSame(k2, k1);
    }
}
