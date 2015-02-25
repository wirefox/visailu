package sovellus.logiikka;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostonlukijaTest {

    public TiedostonlukijaTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void LueOikeaTiedostoKiina() {
        Tiedostonlukija t = new Tiedostonlukija();
        HashMap<String, String> kysymykset = null;
        try {
            kysymykset = t.lueTiedosto("kiinaNumerot.txt");
        } catch (Exception e) {
            System.out.println("lukuvirhe");
        }

        assertNotNull(kysymykset);
        assertNotNull(t.getKysymyslause());

    }

    @Test
    public void LueOikeaTiedostoPaakaupungit() {
        Tiedostonlukija t = new Tiedostonlukija();
        HashMap<String, String> kysymykset = null;
        try {
            kysymykset = t.lueTiedosto("maatJaPaakaupungit.txt");
        } catch (Exception e) {
            System.out.println("lukuvirhe");
        }

        assertNotNull(kysymykset);
        assertNotNull(t.getKysymyslause());

    }

    @Test
    public void testLueVaaraTiedosto() {
        Tiedostonlukija t = new Tiedostonlukija();
        HashMap<String, String> kysymykset = null;
        try {
            kysymykset = t.lueTiedosto("vaara_tiedosto_nimi");
        } catch (Exception e) {
            System.out.println("lukuvirhe");
        }

        assertNull(kysymykset);
        assertNull(t.getKysymyslause());
    }
}
