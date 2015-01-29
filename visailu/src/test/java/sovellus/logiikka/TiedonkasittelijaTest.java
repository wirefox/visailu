package sovellus.logiikka;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;

public class TiedonkasittelijaTest {
    private Kysymys kysymys;
    private HashMap<String, String> kysymyksetJaVastaukset;

    public TiedonkasittelijaTest() {
        this.kysymyksetJaVastaukset = new HashMap<String, String>();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriTekeeTyhjanHashmapin() {
        assertEquals(0, this.kysymyksetJaVastaukset.size());
    }
}
