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
import sovellus.logiikka.Peli;

public class PeliTest {

// TÄMÄNLAISELLA VOI ANTAA TESTISSÄ SYÖTTEEN:       
//      "laita seuraavaksi syötteeksi "Madrid""
//       String data = "Madrid";
//       System.setIn(new ByteArrayInputStream(data.getBytes()));
    private Kysymyssarja kysymyssarja;
    private Kysymys kysymys;
    private Peli peliJossaEiVielaPelattuKierroksia;
    private Peli peliJossaPelattuYksiKierrosJaOikeaVastaus;
    private Peli peliJossaPelattuYksiKierrosJaVaaraVastaus;

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
        this.kysymyssarja = new Kysymyssarja();

        Kysymys k = new Kysymys();
        k.setOikeaVastaus("Madrid");
        k.setKysymyssana("Espanja");

        ArrayList<String> vaaratVastaukset = new ArrayList<String>();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");
        k.setVaaratVastaukset(vaaratVastaukset);

        this.kysymyssarja.lisaaKysymys(k);
        this.peliJossaEiVielaPelattuKierroksia = new Peli("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyssarja);

        this.peliJossaPelattuYksiKierrosJaOikeaVastaus = new Peli("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyssarja);

        this.peliJossaPelattuYksiKierrosJaVaaraVastaus = new Peli("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyssarja);

        //      assertNotNull(this.kysymys);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelinAlussaPelaajallaEiOlePisteita() {
        System.out.println("pisteitä: " + this.peliJossaEiVielaPelattuKierroksia.getPisteitaPelaajalla());
        System.out.println("kierroksia: " + this.peliJossaEiVielaPelattuKierroksia.getKierroksenNumero());
        assertEquals(0, this.peliJossaEiVielaPelattuKierroksia.getPisteitaPelaajalla());
    }

    @Test
    public void pelinAlussaEiOleViimeinenKierros() {
        assertFalse(this.peliJossaEiVielaPelattuKierroksia.onkoVikaKierros());
    }

    @Test
    public void pelinAlussaOnEnsimmäinenKierros() {
        assertEquals(0, this.peliJossaEiVielaPelattuKierroksia.getKierroksenNumero());
    }

    @Test
    public void peliAntaaViisiVastausvaihtoehtoa() {
        assertNotNull(this.peliJossaEiVielaPelattuKierroksia.getVastausvaihtoehdot());
        //VASTAUSVAIHTOEHDOT ON NULL
        assertEquals(5, this.peliJossaEiVielaPelattuKierroksia.getVastausvaihtoehdot().size());
    }

    @Test
    public void kierroksenNumeroOnKaksiKunOllaanKierroksessaKaksi() {
        this.peliJossaEiVielaPelattuKierroksia.setKierroksenNumero(2);
        assertEquals(2, this.peliJossaEiVielaPelattuKierroksia.getKierroksenNumero());
    }

    @Test
    public void vastauksenArviointiKunPelaajaArvasiOikein() {
        String oikeaVastaus = "Madrid";
        System.setIn(new ByteArrayInputStream(oikeaVastaus.getBytes()));
        this.peliJossaPelattuYksiKierrosJaOikeaVastaus.pelaaPeli();
        //      assertEquals("Hienoa, oikea vastaus!", this.peliJossaPelattuYksiKierrosJaOikeaVastaus.vastauksenArviointi("Madrid"));
    }

    @Test
    public void vastauksenArviointiKunPelaajaArvasiVaarin() {
        String vaaraVastaus = "Helsinki";
        System.setIn(new ByteArrayInputStream(vaaraVastaus.getBytes()));
        this.peliJossaPelattuYksiKierrosJaVaaraVastaus.pelaaPeli();
        assertEquals("Nyt meni väärin. Oikea vastaus olisi ollut Madrid", this.peliJossaEiVielaPelattuKierroksia.vastauksenArviointi("Helsinki"));
    }

    @Test
    public void pistetilanneTulostuuOikein() {
        assertEquals("\nPisteesi: 0 / 0\n", this.peliJossaEiVielaPelattuKierroksia.pistetilanteenTulostus());
    }

    public void kierroksenKysymyslauseTulostuuOikein() {
        assertEquals("1: Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:", this.peliJossaEiVielaPelattuKierroksia.getKierroksenKysymyslause());
    }

    public void kierroksenKysymyssanaTulostuuOikein() {
        assertEquals("ESPANJA", this.kysymys.getKysymyssana());
    }
}
