package sovellus.domain;

import javax.swing.SwingUtilities;
import sovellus.gui.GraafinenKayttoliittyma;
import sovellus.gui.Tekstikayttoliittyma;
import sovellus.logiikka.Visailukoordinaattori;

/**
 * Main-luokka, jossa luodaan visailukoordinaattori- ja graafinenKayttoliittyma
 * -oliot ja käynnistetään graafinen käyttöliittymä
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
