package sovellus.domain;

import javax.swing.SwingUtilities;
import sovellus.gui.Kayttoliittyma;
import sovellus.logiikka.Visailukoordinaattori;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Kayttoliittyma());
        Visailukoordinaattori visailukoordinaattori = new Visailukoordinaattori();
        visailukoordinaattori.kaynnista();
    }
}
