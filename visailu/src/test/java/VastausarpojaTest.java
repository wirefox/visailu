
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.logiikka.Vastausarpoja;

public class VastausarpojaTest {

    private ArrayList<String> vastauksia;
    private Vastausarpoja vastausarpoja;

    public VastausarpojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.vastauksia = new ArrayList<String>();
        vastauksia.add("Olvi");
        vastauksia.add("Karjala");
        vastauksia.add("Velko");
        vastauksia.add("Lapin Kulta");
        vastauksia.add("375-olut");
        vastauksia.add("A le Coq");
        vastauksia.add("Pirkka-olut");
        vastauksia.add("Sandels");
        vastauksia.add("Bear Beer");
        this.vastausarpoja = new Vastausarpoja();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void vastausarpojaArpooNeljaVaaraaVastausta() {
        ArrayList<String> vaaratVastaukset = new ArrayList<String>();
        vaaratVastaukset = this.vastausarpoja.arvoVastauksetKysymykselle(this.vastauksia);

        assertEquals(4, vaaratVastaukset.size());
    }
}
