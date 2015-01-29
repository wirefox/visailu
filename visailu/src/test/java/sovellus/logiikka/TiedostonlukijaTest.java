package sovellus.logiikka;


import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovellus.logiikka.Tiedostonlukija;

public class TiedostonlukijaTest {

    public TiedostonlukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }
    
    @Test
    public void testLueOikeaTiedosto() {
        Tiedostonlukija t = new Tiedostonlukija();
        HashMap <String,String> kysymykset = null;
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
        HashMap <String,String> kysymykset = null;
        try {
            kysymykset = t.lueTiedosto("vaara_tiedosto_nimi");
        } catch (Exception e) {
            System.out.println("lukuvirhe");
        }
        
        assertNull(kysymykset);
        assertNull(t.getKysymyslause());
    }
}
