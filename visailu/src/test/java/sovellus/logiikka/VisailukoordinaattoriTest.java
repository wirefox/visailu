package sovellus.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.gui.GraafinenKayttoliittyma;

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
        this.visailukoordinaattori = new Visailukoordinaattori();
        this.kysymyssarja = new Kysymyssarja("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");
    }

    @Test
    public void visailukoordinaattoriLuodaan() {
        assertNotNull(this.visailukoordinaattori);
    }

    @Test
    public void valtiotTiedostonLukemisenJalkeenListaEiOleTyhja() {
        this.visailukoordinaattori.lueTiedosto("valtiot ja pääkaupungit");
        assertNotNull(this.visailukoordinaattori.getKysymyksetJaVastaukset());
    }

    @Test
    public void kiinaTiedostonLukemisenJalkeenListaEiOleTyhja() {
        this.visailukoordinaattori.lueTiedosto("kiinan numerot");
        assertNotNull(this.visailukoordinaattori.getKysymyksetJaVastaukset());
    }

    @Test
    public void valtiotTiedostonLukemisenJalkeenListaOnOikeanPituinen() {
        this.visailukoordinaattori.lueTiedosto("valtiot ja pääkaupungit");
        assertEquals(170, this.visailukoordinaattori.getKysymyksetJaVastaukset().size());
    }

    @Test
    public void kiinaTiedostonLukemisenJalkeenListaOnOikeanPituinen() {
        this.visailukoordinaattori.lueTiedosto("kiinan numerot");
        assertEquals(29, this.visailukoordinaattori.getKysymyksetJaVastaukset().size());
    }

    @Test
    public void pelinLuomisenJalkeenPeliOnOlemassa() {
        this.visailukoordinaattori.luoUusiPeli(this.kysymyssarja);
        assertNotNull(this.visailukoordinaattori.getPeli());
    }
}
