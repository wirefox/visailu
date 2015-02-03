package sovellus.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;

public class KysymysTest {

    private Kysymys kysymys1;
    private Kysymys kysymys2;

    public KysymysTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.kysymys1 = new Kysymys();
        this.kysymys1.lisaaOikeaVastaus("Madrid");

        this.kysymys1.lisaaKysymyssana("Espanja");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        this.kysymys1.lisaaVaaratVastaukset(vaaratVastaukset);

        this.kysymys2 = new Kysymys();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void oikeaVastausOnOikein() {
        assertEquals("Madrid", this.kysymys1.getOikeaVastaus());
    }

    @Test
    public void kysymyssanaOnOikein() {
        assertEquals("Espanja", this.kysymys1.getKysymyssana());
    }

    @Test
    public void vaarienVastaustenMaaraOnNelja() {
        Kysymys k = new Kysymys();

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        k.lisaaVaaratVastaukset(vaaratVastaukset);

        assertEquals(4, k.getVaaratVastaukset().size());
    }

    @Test
    public void lisattyKysymyssanaOnOikein() {
        String maa = "Espanja";
        this.kysymys2.lisaaKysymyssana(maa);
        assertEquals("Espanja", this.kysymys2.getKysymyssana());
    }

    @Test
    public void lisattyOikeaVastausOnOikein() {
        String paakaupunki = "Madrid";
        this.kysymys2.lisaaOikeaVastaus(paakaupunki);
        assertEquals("Madrid", this.kysymys2.getOikeaVastaus());
    }

    @Test
    public void lisatytVaaratVastauksetOvatJuuriLisätyt() {
        String vaara1 = "Helsinki";
        String vaara2 = "Tukholma";
        String vaara3 = "Berliini";
        String vaara4 = "Tokio";
        ArrayList<String> vaarat = new ArrayList<String>();
        vaarat.add(vaara1);
        vaarat.add(vaara2);
        vaarat.add(vaara3);
        vaarat.add(vaara4);
        this.kysymys2.lisaaVaaratVastaukset(vaarat);

        assertEquals(vaarat, this.kysymys2.getVaaratVastaukset());
    }
}