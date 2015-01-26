package sovellus.logiikka;

import sovellus.domain.Kysymyssarja;

public class Visailukoordinaattori {

    private Kysymyssarja kysymyssarja;
    private int pisteitaPelinLopussa;
    private String kysymyslause;

    public Visailukoordinaattori() {
        this.kysymyssarja = new Kysymyssarja();
    }

    public void kaynnista() {
        System.out.println("Hei, tervetuloa visailuun!"); //GUI
        System.out.println("");

        Tiedostonlukija tiedostonlukija = new Tiedostonlukija();
        Tiedonkasittelija tiedonkasittelija = new Tiedonkasittelija(tiedostonlukija.lueTiedosto());
        this.kysymyslause = tiedostonlukija.getKysymyslause();
        this.kysymyssarja = tiedonkasittelija.muodostaKysymyssarja();
        visaile();
        pelinLopetus();
    }

    private void visaile() {
        Peli peli = new Peli(this.kysymyssarja);
        while (true) {
            peli.pelaaKierros(this.kysymyslause);
            if (peli.onkoVikaKierros()) {
                this.pisteitaPelinLopussa = peli.getPisteitaPelaajalla();
                return;
            }
        }
    }

    private void pelinLopetus() {
        if (this.pisteitaPelinLopussa == 20) {
            System.out.println("Olet loistava, kaikki oikein!"); //GUI
        } else if (this.pisteitaPelinLopussa > 15) {
            System.out.println("Hieno suoritus!"); //GUI
        } else if (this.pisteitaPelinLopussa > 10) {
            System.out.println("Enemmän kuin puolet oikein!"); //GUI
        } else if (this.pisteitaPelinLopussa == 10) {
            System.out.println("Puolet oikein!"); //GUI
        } else if (this.pisteitaPelinLopussa < 10) {
            System.out.println("Vielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)"); //GUI
        }
    }
}
