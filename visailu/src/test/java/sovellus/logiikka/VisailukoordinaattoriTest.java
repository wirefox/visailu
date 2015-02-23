package sovellus.logiikka;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.GraafinenKayttoliittyma;

public class VisailukoordinaattoriTest {

    private String kysymyslause;
    private Kysymys kysymys;
    private Tiedostonlukija tiedostonlukija;
    private Tiedonkasittelija tiedonkasittelija;
    private Kysymyssarja kysymyssarja;

    public VisailukoordinaattoriTest() {
    }

    @Before
    public void setUp() {
        this.kysymyslause = "Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ";
    }

//    //TÄMÄ ON IHAN HÖPÖLÖPÖ-TESTI
//    @Test
//    public void kaynnistysmetodinJalkeenOnMuodostettuKysymyssarja() {
//        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
//        visailukoordinaattori.kaynnistaGUI();
//
//        assertEquals("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyslause);
//    }
    @Test
    public void visailukoordinaattoriLuodaan() {
        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
        assertNotNull(visailukoordinaattori);
    }
}
