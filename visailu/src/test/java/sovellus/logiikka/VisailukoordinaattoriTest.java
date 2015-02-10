package sovellus.logiikka;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

public class VisailukoordinaattoriTest {

    private String kysymyslause;
    private Tiedostonlukija tiedostonlukija;
    private Peli peli;

    public VisailukoordinaattoriTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.kysymyslause = "Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ";
    }

    @After
    public void tearDown() {
    }

    //TÄMÄ ON IHAN HÖPÖLÖPÖ-TESTI
    @Test
    public void kaynnistysmetodinJalkeenOnMuodostettuKysymyssarja() {
        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
        visailukoordinaattori.kaynnista();

        assertEquals("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyslause);
    }
}
