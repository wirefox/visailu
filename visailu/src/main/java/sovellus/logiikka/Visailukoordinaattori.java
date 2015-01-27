package sovellus.logiikka;

import sovellus.domain.Kysymyssarja;
import sovellus.gui.Tekstikayttoliittyma;

public class Visailukoordinaattori {
    
    private Kysymyssarja kysymyssarja;
    private int pisteitaPelinLopussa;
    private String kysymyslause;
    private Tekstikayttoliittyma tekstikayttoliittyma;
    
    public Visailukoordinaattori() {
        this.kysymyssarja = new Kysymyssarja();
    }
    
    public void kaynnista(Tekstikayttoliittyma tekstikayttoliittyma) {
        this.tekstikayttoliittyma = tekstikayttoliittyma;
        Tiedostonlukija tiedostonlukija = new Tiedostonlukija();
        Tiedonkasittelija tiedonkasittelija = new Tiedonkasittelija(tiedostonlukija.lueTiedosto());
        this.kysymyslause = tiedostonlukija.getKysymyslause();
        this.kysymyssarja = tiedonkasittelija.muodostaKysymyssarja();
        visaile();
        this.tekstikayttoliittyma.tulosta(pelinLopetus());
    }
    
    private void visaile() {
        Peli peli = new Peli(this.kysymyssarja, this.tekstikayttoliittyma);
        this.tekstikayttoliittyma.tulosta("Hei, tervetuloa visailuun!\n");
        while (true) {
            peli.pelaaKierros(this.kysymyslause);
            if (peli.onkoVikaKierros()) {
                this.pisteitaPelinLopussa = peli.getPisteitaPelaajalla();
                return;
            }
        }
    }
    
    private String pelinLopetus() {
        if (this.pisteitaPelinLopussa == 20) {
            return "\nOlet loistava, kaikki oikein!"; 
        } else if (this.pisteitaPelinLopussa > 15) {
            return "\nHieno suoritus!"; //GUI
        } else if (this.pisteitaPelinLopussa > 10) {
            return "\nEnemmän kuin puolet oikein!"; 
        } else if (this.pisteitaPelinLopussa == 10) {
            return "\nPuolet oikein!"; 
        } else if (this.pisteitaPelinLopussa < 10) {
            return "\nVielä olisi vähän treenattavaa, jatka pelaamista niin opit! :)"; 
        }
        return null;
    }
}
