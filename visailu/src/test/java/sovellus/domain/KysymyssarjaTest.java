package sovellus.domain;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KysymyssarjaTest {

    private Kysymys kysymys1;
    private Kysymys kysymys2;
    private Kysymyssarja kysymyssarja1;
    private Kysymyssarja kysymyssarja2;
    private Kysymyssarja kysymyssarja3;
    private Random arpoja;
    private ArrayList<Integer> arvotutKysymyksenNumerot;

    public KysymyssarjaTest() {
        this.kysymyssarja1 = new Kysymyssarja("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");
        this.kysymyssarja2 = new Kysymyssarja("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");
        this.kysymyssarja3 = new Kysymyssarja("Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:");
        this.arpoja = new Random();
        this.arvotutKysymyksenNumerot = new ArrayList<>();
        this.kysymys1 = new Kysymys();
        this.kysymys2 = new Kysymys();
    }

    @Before
    public void setUp() {
        this.kysymys1.setKysymyssana("Espanja");
        this.kysymys1.setOikeaVastaus("Madrid");

        this.kysymys2.setKysymyssana("Thaimaa");
        this.kysymys2.setOikeaVastaus("Bangkok");

        ArrayList<String> vaaratVastaukset = new ArrayList();
        vaaratVastaukset.add("Helsinki");
        vaaratVastaukset.add("Tukholma");
        vaaratVastaukset.add("Berliini");
        vaaratVastaukset.add("Moskova");

        this.kysymys1.setVaaratVastaukset(vaaratVastaukset);
        this.kysymys2.setVaaratVastaukset(vaaratVastaukset);

        this.kysymyssarja1.lisaaKysymys(this.kysymys1);
        this.kysymyssarja2.lisaaKysymys(this.kysymys1);
        this.kysymyssarja2.lisaaKysymys(this.kysymys2);
    }

    @Test
    public void kysymyksenLisaamisenJalkeenListanKokoOnYksi() {
        assertEquals(1, this.kysymyssarja1.getKysymystenLkm());
    }

    @Test
    public void kahdenKysymyksenLisaamisenJalkeenListanKokoOnKaksi() {
        assertEquals(2, this.kysymyssarja2.getKysymystenLkm());
    }

    @Test
    public void kysymysEiOleNull() {
        this.kysymyssarja3.lisaaKysymys(this.kysymys1);
        assertNotNull(this.kysymys1);
    }

    @Test
    public void kysymyslistallaOnOikeatKaksiKysymysta() {
        ArrayList<Kysymys> kysymyksetListalla = new ArrayList<>();
        kysymyksetListalla.add(kysymys1);
        kysymyksetListalla.add(kysymys2);
        assertEquals(kysymyksetListalla.get(0), this.kysymyssarja2.getKysymys(0));
        assertEquals(kysymyksetListalla.get(1), this.kysymyssarja2.getKysymys(1));
    }

    @Test
    public void seuraavanKysymyksenPyyntoAntaaListanSeuraavanKysymyksen() {
        assertEquals(this.kysymys1, this.kysymyssarja1.annaSeuraavaKysymys(0));
    }

    @Test
    public void kysymyslistanKokoPysyySamanaListanSekoittamisenJalkeen() {
        int kysymystenLkmEnnenSekoittamista = this.kysymyssarja2.getKysymystenLkm();
        this.kysymyssarja2.sekoitaSarjanKysymykset();
        int kysymystenLkmSekoittamisenJalkeen = this.kysymyssarja2.getKysymystenLkm();

        assertEquals(kysymystenLkmEnnenSekoittamista, kysymystenLkmSekoittamisenJalkeen);
    }
}
