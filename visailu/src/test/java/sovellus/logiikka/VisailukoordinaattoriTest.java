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
        this.visailukoordinaattori.lueTiedosto("kiinaNumerot.txt");
        assertNotNull(this.visailukoordinaattori.getKysymyksetJaVastaukset());
    }
}
