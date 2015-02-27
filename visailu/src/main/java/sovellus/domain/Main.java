package sovellus.domain;

import javax.swing.SwingUtilities;
import sovellus.gui.GraafinenKayttoliittyma;
import sovellus.logiikka.Visailukoordinaattori;

/**
 * Main-luokka, joka luo visailukoordinaattori- ja graafinenKayttoliittyma
 * -oliot ja käynnistää graafisen käyttöliittymän
 *
 * @author elina
 */
public class Main {

    public static void main(String[] args) {
        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
        GraafinenKayttoliittyma graafinenKayttis = new GraafinenKayttoliittyma(visailukoordinaattori);
        SwingUtilities.invokeLater(graafinenKayttis);
    }
}
