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
import sovellus.gui.Tekstikayttoliittyma;

public class VisailukoordinaattoriTest {

    private String kysymyslause;
    private Kysymys kysymys;
    private Tiedostonlukija tiedostonlukija;
    private Tiedonkasittelija tiedonkasittelija;
    private Kysymyssarja kysymyssarja;
    //   private Peli peli;

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

//    //TÄMÄ ON IHAN HÖPÖLÖPÖ-TESTI
//    @Test
//    public void kaynnistysmetodinJalkeenOnMuodostettuKysymyssarja() {
//        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
//        visailukoordinaattori.kaynnistaGUI();
//
//        assertEquals("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyslause);
//    }
    @Test
    public void pelinValmistelutoimienAikanaMuodostetaanKysymyssarjaJossaKysymyksia() {
        //GraafinenKayttoliittyma kayttis = new GraafinenKayttoliittyma(this.peli);
        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
        this.tiedostonlukija = new Tiedostonlukija();
        String kysymyslause = this.tiedostonlukija.getKysymyslause();
        HashMap<String, String> kysymyksetJaVastaukset = new HashMap<String, String>();
        this.tiedonkasittelija = new Tiedonkasittelija(kysymyksetJaVastaukset, kysymyslause);
        this.kysymyssarja = this.tiedonkasittelija.muodostaKysymyssarja();
        Peli peli = new Peli(kysymyslause, this.kysymyssarja);
        this.kysymys = peli.getKysymys();
        assertNotNull(this.kysymys);
    }

    @Test
    public void visailukoordinaattoriLuodaan() {
        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
        assertNotNull(visailukoordinaattori);
    }
}
