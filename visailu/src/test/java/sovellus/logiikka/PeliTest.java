package sovellus.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Tiedostonlukija;

public class PeliTest {

    private Peli peli1;
    private Peli peli2;

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
        Kysymys kysymys1 = new Kysymys();

        kysymys1.lisaaOikeaVastaus("Madrid");
        kysymys1.lisaaKysymyssana("Espanja");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");
        kysymys1.lisaaVaaratVastaukset(vaaratVastaukset);

        Kysymyssarja kysymyssarja = new Kysymyssarja();
        kysymyssarja.lisaaKysymys(kysymys1);
        this.peli1 = new Peli(kysymyssarja);
        this.peli2 = new Peli(kysymyssarja);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelinAlussaPelaajallaEiOlePisteita() {
        assertEquals(0, this.peli1.getPisteitaPelaajalla());
    }

    @Test
    public void pelinAlussaEiOleViimeinenKierros() {
        assertFalse(this.peli1.onkoVikaKierros());
    }

    @Test
    public void pelinAlussaOnEnsimmäinenKierros() {
        assertEquals(1, this.peli1.getKierroksenNumero());
    }

    public void pisteTilanteenTulostusKunEnsimmainenKierrosTakanaJaPelaajaArvannutVaarin() {
        //???
    }

    public void pelaajanVastauksenArviointiKunVastasiOikein() {
        this.peli2.pelaaKierros("Mikä on seuraavan valtion pääkaupunki? ");
        //???
    }
}
