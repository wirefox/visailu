package sovellus.domain;

import javax.swing.SwingUtilities;
import sovellus.gui.GraafinenKayttoliittyma;
import sovellus.gui.Tekstikayttoliittyma;
import sovellus.logiikka.Visailukoordinaattori;

public class Main {

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new GraafinenKayttoliittyma());
        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
        visailukoordinaattori.kaynnista();
    }
}
