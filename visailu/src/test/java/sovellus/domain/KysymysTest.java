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
    private Kysymys kysymys3;

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
        this.kysymys1.setOikeaVastaus("Madrid");

        this.kysymys1.setKysymyssana("Espanja");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        this.kysymys1.setVaaratVastaukset(vaaratVastaukset);

        this.kysymys2 = new Kysymys();
        this.kysymys3 = new Kysymys();
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
        assertEquals("ESPANJA", this.kysymys1.getKysymyssana());
    }

    @Test
    public void vaarienVastaustenMaaraOnNelja() {
        Kysymys k = new Kysymys();

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        k.setVaaratVastaukset(vaaratVastaukset);

        assertEquals(4, k.getVaaratVastaukset().size());
    }

    @Test
    public void vaaratVastauksetEivatOleNull() {
        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");
        this.kysymys3.setVaaratVastaukset(vaaratVastaukset);

        assertNotNull(vaaratVastaukset);
    }

    @Test
    public void lisattyKysymyssanaOnOikein() {
        String maa = "Espanja";
        this.kysymys2.setKysymyssana(maa.toUpperCase());
        assertEquals("ESPANJA", this.kysymys2.getKysymyssana());
    }

    @Test
    public void lisattyOikeaVastausOnOikein() {
        String paakaupunki = "Madrid";
        this.kysymys2.setOikeaVastaus(paakaupunki);
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
        this.kysymys2.setVaaratVastaukset(vaarat);

        assertEquals(vaarat, this.kysymys2.getVaaratVastaukset());
    }

    @Test
    public void kertooTrueJosOikeaVastaus() {
        boolean vastaus = this.kysymys1.onkoOikeaVastaus("Madrid");
        Boolean oikeaVastaus = true;
        assertEquals(oikeaVastaus, vastaus);
    }

    @Test
    public void kertooFalseJosVaaraVastaus() {
        boolean vastaus = this.kysymys1.onkoOikeaVastaus("Helsinki");
        Boolean vaaraVastaus = false;
        assertEquals(vaaraVastaus, vastaus);
    }
}
