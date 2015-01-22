
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;

public class KysymysTest {

    private Kysymys kysymys;

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
        this.kysymys = new Kysymys();
        this.kysymys.lisaaOikeaVastaus("Madrid");

        this.kysymys.lisaaKysymyssana("Mikä on Espanjan pääkaupunki?");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        this.kysymys.lisaaVaaratVastaukset(vaaratVastaukset);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void oikeaVastausOnOikein() {
        assertEquals("Madrid", this.kysymys.getOikeaVastaus());
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
}
