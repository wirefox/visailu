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

 //   private Kysymys kysymys;
    //   private HashMap<String, String> kysymyksetJaVastaukset;
    public TiedonkasittelijaTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //     this.kysymyksetJaVastaukset = new HashMap<String, String>();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriTallettaaSaamansaHashmapinOikeanKokoisena() {
        String kysymys1 = "kysymys1";
        String vastaus1 = "vastaus1";
        String kysymys2 = "kysymys2";
        String vastaus2 = "vastaus2";

        HashMap<String, String> kysymysVastaus = new HashMap<String, String>();
        kysymysVastaus.put(kysymys1, vastaus1);
        kysymysVastaus.put(kysymys2, vastaus2);

        Tiedonkasittelija tiedonkasittelija = new Tiedonkasittelija(kysymysVastaus, "Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");
        assertEquals(2, tiedonkasittelija.getKysymyksetJaVastaukset().size());
    }
}
