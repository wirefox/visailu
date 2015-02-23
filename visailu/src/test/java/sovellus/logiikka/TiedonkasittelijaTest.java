package sovellus.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

public class TiedonkasittelijaTest {

    public TiedonkasittelijaTest() {
    }

    @Before
    public void setUp() {
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

    @Test
    public void luotuKysymysSarjaOnOikeanKokoinen() {
        String kysymys1 = "kysymys1";
        String vastaus1 = "vastaus1";
        String kysymys2 = "kysymys2";
        String vastaus2 = "vastaus2";
        String kysymys3 = "kysymys3";
        String vastaus3 = "vastaus3";
        String kysymys4 = "kysymys4";
        String vastaus4 = "vastaus4";
        String kysymys5 = "kysymys5";
        String vastaus5 = "vastaus5";
        String kysymys6 = "kysymys6";
        String vastaus6 = "vastaus6";

        HashMap<String, String> kysymysVastaus = new HashMap<String, String>();
        kysymysVastaus.put(kysymys1, vastaus1);
        kysymysVastaus.put(kysymys2, vastaus2);
        kysymysVastaus.put(kysymys3, vastaus3);
        kysymysVastaus.put(kysymys4, vastaus4);
        kysymysVastaus.put(kysymys5, vastaus5);
        kysymysVastaus.put(kysymys6, vastaus6);

        Tiedonkasittelija tiedonkasittelija = new Tiedonkasittelija(kysymysVastaus, "Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");

        Kysymyssarja kysymyssarja = tiedonkasittelija.muodostaKysymyssarja();

        assertEquals(6, kysymyssarja.getKysymystenLkm());
    }
}
