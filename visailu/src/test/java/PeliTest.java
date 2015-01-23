
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymyssarja;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Tiedostonlukija;

public class PeliTest {

    private Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Kysymyssarja kysymyssarja = new Kysymyssarja();
        this.peli = new Peli(kysymyssarja);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {}
    
    @Test
    public void pelinAlussaPelaajallaEiOlePisteita() {
        assertEquals(0, this.peli.getPisteitaPelaajalla());
    }

    @Test
    public void pelinAlussaEiOleViimeinenKierros() {
        assertEquals(false, this.peli.onkoVikaKierros());
    }

    @Test
    public void kahdeskymmenesKierrosOnViimeinenKierros() {
// mitenköhän tätä voisi testata...ei ainakaan näin...
//        for (int i = 0; i < 20; i++) {
//            this.peli.pelaaKierros();
//        }
//        assertEquals(true, this.peli.onkoVikaKierros());
    }

    public void pisteTilanteenTulostusKunEnsimmainenKierrosTakanaJaPelaajaArvannutVaarin() {
        // ..ja entä miten tätä pystyisi testaamaan...
        //     assertEquals("0 / 1", this.peli.getPisteitaPelaajalla() + " / " + this.peli.getKierroksenNumero());       
    }

    public void pelaajanVastauksenArviointiKunVastasiOikein() {
// miten tätä pystyisi testaamaan...tarvitsisi oikean syötteen..
//        assertEquals("Hienoa, oikea vastaus!", this.peli.vastauksenArviointi(String vastausTahan));
    }
}
