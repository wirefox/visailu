package sovellus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.gui.Tekstikayttoliittyma;

public class VisailukoordinaattoriTest {

    private Tekstikayttoliittyma kayttis;
    private String kysymyslause;
    private Peli peli;
    private Visailukoordinaattori koordinaattori;

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
        this.koordinaattori = new Visailukoordinaattori();
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void pelinLopetustekstiKunPelaajallaEiPisteita() {
//        assertNotNull(this.peli);
//        assertNotNull(this.koordinaattori);
//        assertNotNull(this.koordinaattori.pelinLopetusteksti());
//        assertEquals("Vielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)", this.koordinaattori.pelinLopetusteksti());
//    }
}
