package sovellus.logiikka;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Tiedostonlukija;

public class PeliTest {

    private Kysymyssarja kysymyssarja;
    private Tekstikayttoliittyma tekstikayttoliittyma;
    private String kysymyslause;
    private Kysymys kysymys;
    private int pisteitaPelaajalla;
    private int kierroksenNumero;
    private Peli peli;
    private Scanner lukija;

    public PeliTest() {
        this.kysymyssarja = new Kysymyssarja();
        this.tekstikayttoliittyma = new Tekstikayttoliittyma();
        this.kysymyslause = "Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ";
        this.kysymys = new Kysymys();
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 1;
        this.lukija = new Scanner(System.in);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // laita seuraavaksi syötteeksi "Madrid"
        String data = "Madrid";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        this.kysymys.lisaaOikeaVastaus("Madrid");
        this.kysymys.lisaaKysymyssana("Espanja");

        ArrayList<String> vaaratVastaukset = new ArrayList<String>();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");
        this.kysymys.lisaaVaaratVastaukset(vaaratVastaukset);

        this.kysymyssarja.lisaaKysymys(this.kysymys);
        this.peli = new Peli(this.tekstikayttoliittyma, this.kysymyslause);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelinAlussaPelaajallaEiOlePisteita() {
        assertEquals(0, this.peli.getPisteitaPelaajalla());
    }

    @Test
    public void pelinAlussaEiOleViimeinenKierros() {
        assertFalse(this.peli.onkoVikaKierros());
    }

    @Test
    public void pelinAlussaOnEnsimmäinenKierros() {
        assertEquals(0, this.peli.getKierroksenNumero());
    }

//    @Test
//    public void peliAntaaViisiVastausvaihtoehtoa() {
//        assertNotNull(this.peli);
//
//        this.peli.pelaaKierros(this.kysymys);
//
//        assertNotNull(this.peli.annaVastausvaihtoehdot());
//        assertEquals(5, this.peli.annaVastausvaihtoehdot().size());
//    }
//
//    @Test
//    public void kierroksenNumeroOnKaksiKunOllaanKierroksessaKaksi() {
//        assertEquals(2, this.kierroksenNumero);
//    }
//
//    @Test
//    public void vastauksenArviointiKunPelaajaArvasiOikein() {
//        this.peli.vastauksenArviointi("Madrid");
//        assertEquals("Hienoa, oikea vastaus!", this.peli.vastauksenArviointi("Madrid"));
//    }
//
//    @Test
//    public void vastauksenArviointiKunPelaajaArvasiVaarin() {
//        this.peli.vastauksenArviointi("Helsinki");
//        assertEquals("Nyt meni väärin. Oikea vastaus olisi ollut Madrid", this.peli.vastauksenArviointi("Helsinki"));
//    }

    @Test
    public void pistetilanneTulostuuOikein() {
        assertEquals("\nPisteesi: 0 / 0\n", this.peli.pistetilanteenTulostus());
    }

    public void kierroksenKysymyslauseTulostuuOikein() {
        assertEquals("1: Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:", this.peli.annaKierroksenKysymyslause());
    }

    public void kierroksenKysymyssanaTulostuuOikein() {
        assertEquals("ESPANJA", this.peli.annaKysymyssana());
    }
}
