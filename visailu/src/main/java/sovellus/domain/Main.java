package sovellus.domain;

import sovellus.logiikka.Visailukoordinaattori;

public class Main {

    public static void main(String[] args) {

        Visailukoordinaattori visailu = new Visailukoordinaattori();
        visailu.kaynnista();
    }
}
