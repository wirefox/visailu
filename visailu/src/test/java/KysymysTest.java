
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kysymyssananLisaamisenJalkeenKysymyssanaOnListassa() {
        this.kysymys.lisaaKysymyssana("olut");
        String vastaus = this.kysymys.getKysymyssana();
        assertEquals("olut", vastaus);
    }
}
