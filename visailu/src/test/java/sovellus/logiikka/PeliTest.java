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
    private Kysymyssarja kysymyssarjaYksiKysymys;
    private Kysymyssarja kysymyssarja10Kysymysta;
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
        this.kysymyssarjaYksiKysymys = new Kysymyssarja("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");
        this.kysymyssarja10Kysymysta = new Kysymyssarja("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");

        Kysymys k1 = new Kysymys();
        k1.setOikeaVastaus("Madrid");
        k1.setKysymyssana("Espanja");

        Kysymys k2 = new Kysymys();
        k2.setOikeaVastaus("Madrid");
        k2.setKysymyssana("Espanja");

        Kysymys k3 = new Kysymys();
        k3.setOikeaVastaus("Madrid");
        k3.setKysymyssana("Espanja");

        Kysymys k4 = new Kysymys();
        k4.setOikeaVastaus("Madrid");
        k4.setKysymyssana("Espanja");

        Kysymys k5 = new Kysymys();
        k5.setOikeaVastaus("Madrid");
        k5.setKysymyssana("Espanja");

        Kysymys k6 = new Kysymys();
        k6.setOikeaVastaus("Madrid");
        k6.setKysymyssana("Espanja");

        Kysymys k7 = new Kysymys();
        k7.setOikeaVastaus("Madrid");
        k7.setKysymyssana("Espanja");

        Kysymys k8 = new Kysymys();
        k8.setOikeaVastaus("Madrid");
        k8.setKysymyssana("Espanja");

        Kysymys k9 = new Kysymys();
        k9.setOikeaVastaus("Madrid");
        k9.setKysymyssana("Espanja");

        Kysymys k10 = new Kysymys();
        k10.setOikeaVastaus("Madrid");
        k10.setKysymyssana("Espanja");

        ArrayList<String> vaaratVastaukset = new ArrayList<String>();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");
        k1.setVaaratVastaukset(vaaratVastaukset);

        this.kysymyssarjaYksiKysymys.lisaaKysymys(k1);

        this.kysymyssarja10Kysymysta.lisaaKysymys(k1);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k2);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k3);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k4);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k5);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k6);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k7);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k8);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k9);
        this.kysymyssarja10Kysymysta.lisaaKysymys(k10);

        this.peliJossaEiVielaPelattuKierroksia = new Peli("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyssarjaYksiKysymys);

        this.peliJossaPelattuYksiKierrosJaOikeaVastaus = new Peli("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyssarja10Kysymysta);

        this.peliJossaPelattuYksiKierrosJaVaaraVastaus = new Peli("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ", this.kysymyssarja10Kysymysta);
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
    public void pelinAlussaJatketaanPelia() {
        assertTrue(this.peliJossaEiVielaPelattuKierroksia.jatketaankoPelia());
    }

    @Test
    public void pelinVikallaKierroksellaEiJatketaPelia() {
        this.peliJossaEiVielaPelattuKierroksia.setKierroksenNumero(10);
        assertFalse(this.peliJossaEiVielaPelattuKierroksia.jatketaankoPelia());
    }

    @Test
    public void pelinAlussaOnEnsimmäinenKierros() {
        assertEquals(0, this.peliJossaEiVielaPelattuKierroksia.getKierroksenNumero());
    }

    @Test
    public void peliAntaaViisiVastausvaihtoehtoa() {
        this.peliJossaEiVielaPelattuKierroksia.vaihdaSeuraavaKysymys();
        assertEquals(5, this.peliJossaEiVielaPelattuKierroksia.muodostaVastausvaihtoehdot().size());
    }

    @Test
    public void kierroksenNumeroOnKaksiKunOllaanKierroksessaKaksi() {
        this.peliJossaEiVielaPelattuKierroksia.setKierroksenNumero(2);
        assertEquals(2, this.peliJossaEiVielaPelattuKierroksia.getKierroksenNumero());
    }

    @Test
    public void vastauksenArviointiKunPelaajaArvasiOikein() {
        String oikeaVastaus = "Madrid";
        this.peliJossaEiVielaPelattuKierroksia.vaihdaSeuraavaKysymys();
        String tulos = this.peliJossaEiVielaPelattuKierroksia.vastauksenArviointi(oikeaVastaus);

        assertEquals("Hienoa, oikea vastaus!", tulos);
    }

    @Test
    public void oikeanVastauksenJalkeenPelaajaSaaPisteen() {
        String oikeaVastaus = "Madrid";
        this.peliJossaEiVielaPelattuKierroksia.vaihdaSeuraavaKysymys();
        this.peliJossaEiVielaPelattuKierroksia.vastauksenArviointi(oikeaVastaus);

        assertEquals(1, this.peliJossaEiVielaPelattuKierroksia.getPisteitaPelaajalla());
    }

    @Test
    public void vastauksenArviointiKunPelaajaArvasiVaarin() {
        String vaaraVastaus = "Helsinki";
        this.peliJossaEiVielaPelattuKierroksia.vaihdaSeuraavaKysymys();
        String tulos = this.peliJossaEiVielaPelattuKierroksia.vastauksenArviointi(vaaraVastaus);

        assertEquals("Nyt meni väärin. Oikea vastaus olisi ollut Madrid", tulos);
    }

    @Test
    public void vaaranVastauksenJalkeenPelaajaEiSaaPistetta() {
        String vaaraVastaus = "Helsinki";
        this.peliJossaEiVielaPelattuKierroksia.vaihdaSeuraavaKysymys();
        this.peliJossaEiVielaPelattuKierroksia.vastauksenArviointi(vaaraVastaus);

        assertEquals(0, this.peliJossaEiVielaPelattuKierroksia.getPisteitaPelaajalla());
    }

    @Test
    public void vastauksenArvioinninJalkeenPelinKierrosnumeroKasvaa() {
        String vaaraVastaus = "Helsinki";
        this.peliJossaEiVielaPelattuKierroksia.vaihdaSeuraavaKysymys();
        String tulos = this.peliJossaEiVielaPelattuKierroksia.vastauksenArviointi(vaaraVastaus);

        assertEquals(1, this.peliJossaEiVielaPelattuKierroksia.getKierroksenNumero());
    }

    @Test
    public void pistetilanneTulostuuOikein() {
        assertEquals("Pisteesi: 0 / 0", this.peliJossaEiVielaPelattuKierroksia.pistetilanteenTulostus());
    }

    @Test
    public void kierroksenKysymyslauseTulostuuOikein() {
        assertEquals("1: Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:", this.peliJossaEiVielaPelattuKierroksia.getKierroksenKysymyslause());
    }

    @Test
    public void kierroksenKysymyslauseTulostuuOikeinKunYhdeksasKierros() {
        this.peliJossaPelattuYksiKierrosJaVaaraVastaus.setKierroksenNumero(8);

        assertEquals("9: Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:", this.peliJossaPelattuYksiKierrosJaVaaraVastaus.getKierroksenKysymyslause());
    }

    @Test
    public void kierroksenKysymyssanaTulostuuOikein() {
        this.peliJossaEiVielaPelattuKierroksia.vaihdaSeuraavaKysymys();
        assertEquals("ESPANJA", this.peliJossaEiVielaPelattuKierroksia.getKysymys().getKysymyssana());
    }

    @Test
    public void pelinLopetusTekstiKunPelaajalla10Pistetta() {
        this.peliJossaEiVielaPelattuKierroksia.setPisteitaPelaajalla(10);
        assertEquals("Game over! Olet loistava, kaikki oikein!", this.peliJossaEiVielaPelattuKierroksia.pelinLopetusteksti());
    }

    @Test
    public void pelinLopetusTekstiKunPelaajalla9Pistetta() {
        this.peliJossaEiVielaPelattuKierroksia.setPisteitaPelaajalla(9);
        assertEquals("Game over! Hieno suoritus!", this.peliJossaEiVielaPelattuKierroksia.pelinLopetusteksti());
    }

    @Test
    public void pelinLopetusTekstiKunPelaajalla8Pistetta() {
        this.peliJossaEiVielaPelattuKierroksia.setPisteitaPelaajalla(8);
        assertEquals("Game over! Hieno suoritus!", this.peliJossaEiVielaPelattuKierroksia.pelinLopetusteksti());
    }

    @Test
    public void pelinLopetusTekstiKunPelaajalla6Pistetta() {
        this.peliJossaEiVielaPelattuKierroksia.setPisteitaPelaajalla(6);
        assertEquals("Game over! Enemmän kuin puolet oikein!", this.peliJossaEiVielaPelattuKierroksia.pelinLopetusteksti());
    }

    @Test
    public void pelinLopetusTekstiKunPelaajalla5Pistetta() {
        this.peliJossaEiVielaPelattuKierroksia.setPisteitaPelaajalla(5);
        assertEquals("Game over! Vielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)", this.peliJossaEiVielaPelattuKierroksia.pelinLopetusteksti());
    }
}
