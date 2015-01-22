package sovellus.logiikka;

import sovellus.domain.Kysymyssarja;

public class Visailukoordinaattori {

    private Kysymyssarja kysymyssarja;
    private int pisteitaPelinLopussa;

    public void kaynnista() {
        System.out.println("Hei, tervetuloa visailuun!");
        System.out.println("");

        //luo uusi tiedostonlukija, ja luetuta tiedosto HashMapiin (maa, pääkaupunki)
        //luo uusi tiedonkäsittelijä, joka muodostaa luetusta tiedostosta
        //kysymyksiä sisältävän kysymyssarjan (maa + oikea vastaus sekä
        //neljä muuta vastausvaihtoehtoa
        Tiedostonlukija tiedostonlukija = new Tiedostonlukija();
        Tiedonkasittelija tiedonkasittelija = new Tiedonkasittelija(tiedostonlukija.lueTiedosto());
        this.kysymyssarja = tiedonkasittelija.muodostaKysymyssarja();
        visaile();
        pelinLopetus();
    }

    //visaile-metodi, jossa ohjataan pelin kulkua, eli luodaan uusi peli,
    //ja pyydetään peliltä uutta kierrosta niin kauan kunnes on
    // pelin viimeinen kierros
    private void visaile() {
        Peli peli = new Peli(this.kysymyssarja);
        while (true) {
            peli.pelaaKierros();
            if (peli.onkoVikaKierros()) {
                this.pisteitaPelinLopussa = peli.getPisteitaKasassa();
                return;
            }
        }
    }

    //pelinLopetus-metodi, jossa vikan kierroksen jälkeen annetaan pelaajalle
    //arvio hänen suoriutumisestaan
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
