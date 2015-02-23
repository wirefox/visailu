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
import sovellus.gui.GraafinenKayttoliittyma;

//Tähän ei kai ole mahdollista tehdä lisää testejä?!?
public class VisailukoordinaattoriTest {

    private Kysymys kysymys;
    private Kysymyssarja kysymyssarja;
    private Visailukoordinaattori visailukoordinaattori;
    private Peli peli;
    private Tiedonkasittelija tiedonkasittelija;
    private Tiedostonlukija tiedostonlukija;
    private GraafinenKayttoliittyma graafinenKayttis;

    public VisailukoordinaattoriTest() {
    }

    @Before
    public void setUp() {
        // this.kysymyslause = "Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista: ";
        this.visailukoordinaattori = new Visailukoordinaattori();

        this.kysymyssarja = new Kysymyssarja("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");

        this.kysymys = new Kysymys();
        kysymys.setOikeaVastaus("Madrid");
        kysymys.setKysymyssana("Espanja");

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
        this.kysymys.setVaaratVastaukset(vaaratVastaukset);

        this.kysymyssarja.lisaaKysymys(this.kysymys);

        this.kysymyssarja.lisaaKysymys(k2);
        this.kysymyssarja.lisaaKysymys(k3);
        this.kysymyssarja.lisaaKysymys(k4);
        this.kysymyssarja.lisaaKysymys(k5);
        this.kysymyssarja.lisaaKysymys(k6);
        this.kysymyssarja.lisaaKysymys(k7);
        this.kysymyssarja.lisaaKysymys(k8);
        this.kysymyssarja.lisaaKysymys(k9);
        this.kysymyssarja.lisaaKysymys(k10);

        this.peli = new Peli(this.kysymyssarja);

        this.graafinenKayttis = new GraafinenKayttoliittyma(this.visailukoordinaattori);
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
        assertNotNull(this.visailukoordinaattori);
    }

}
