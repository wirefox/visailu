package sovellus.logiikka;

import sovellus.domain.Kysymyssarja;

public class Visailukoordinaattori {
    private Kysymyssarja kysymyssarja;
    private int pisteitaPelinLopussa;
    
    public Visailukoordinaattori() {
        this.kysymyssarja = new Kysymyssarja();
    }

    public void kaynnista() {
        System.out.println("Hei, tervetuloa visailuun!");
        System.out.println("");

        Tiedostonlukija tiedostonlukija = new Tiedostonlukija();
        Tiedonkasittelija tiedonkasittelija = new Tiedonkasittelija(tiedostonlukija.lueTiedosto());
        this.kysymyssarja = tiedonkasittelija.muodostaKysymyssarja();
        visaile();
        pelinLopetus();
    }

    private void visaile() {
        Peli peli = new Peli(this.kysymyssarja);
        while (true) {
            peli.pelaaKierros();
            if (peli.onkoVikaKierros()) {
                this.pisteitaPelinLopussa = peli.getPisteitaPelaajalla();
                return;
            }
        }
    }

    private void pelinLopetus() {
        if (this.pisteitaPelinLopussa == 20) {
            System.out.println("Olet loistava, kaikki oikein!");
        } else if (this.pisteitaPelinLopussa > 15) {
            System.out.println("Hieno suoritus!");
        } else if (this.pisteitaPelinLopussa > 10) {
            System.out.println("Enemmän kuin puolet oikein!");
        } else if (this.pisteitaPelinLopussa == 10) {
            System.out.println("Puolet oikein!");
        } else if (this.pisteitaPelinLopussa < 10) {
            System.out.println("Vielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)");
        }
    }
}
