package sovellus.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;

public class Peli {

    private Kysymyssarja kysymyssarja;
    private Kysymys kysymys;
    private int pisteitaPelaajalla;
    private int kierroksenNumero;
    private Scanner lukija;

    public Peli(Kysymyssarja kysymyssarja) {
        this.kysymyssarja = kysymyssarja;
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 1;
        this.lukija = new Scanner(System.in);
    }

    public void pelaaKierros() {
        System.out.println(this.kierroksenNumero + ": " + "Mikä on allaolevan valtion pääkaupunki, valitse vaihtoehdoista:"); //GUI
        this.kysymys = this.kysymyssarja.arvoKysymys();
        System.out.println(this.kysymys.getKysymyssana().toUpperCase()); //GUI
        System.out.println("");

        annaVastausvaihtoehdot();

        System.out.print("Kirjoita arvauksesi: "); //GUI
        String vastaus = this.lukija.nextLine();

        vastauksenArviointi(vastaus);

        pistetilanteenTulostus();
        this.kierroksenNumero++;
    }

    public boolean onkoVikaKierros() {
        if (getKierroksenNumero() > 20) {
            return true;
        } else {
            return false;
        }
    }

    public int getKierroksenNumero() {
        return this.kierroksenNumero;
    }

    public int getPisteitaPelaajalla() {
        return this.pisteitaPelaajalla;
    }

    private void annaVastausvaihtoehdot() {
        ArrayList<String> vastausvaihtoehdot = this.kysymys.getVaaratVastaukset();
        vastausvaihtoehdot.add(this.kysymys.getOikeaVastaus());
        Collections.shuffle(vastausvaihtoehdot);
        for (String paakaupunki : vastausvaihtoehdot) {
            System.out.println(paakaupunki);
        }
        System.out.println("");
    }

    private void vastauksenArviointi(String vastaus) {
        if (vastaus.toUpperCase().equals(this.kysymys.getOikeaVastaus().toUpperCase())) {
            System.out.println("Hienoa, oikea vastaus!"); //GUI
            this.pisteitaPelaajalla++;
        } else {
            System.out.println("Nyt meni väärin"); //GUI
            System.out.println("Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus()); //GUI
        }
    }

    private void pistetilanteenTulostus() {
        System.out.println("");
        System.out.println("Pisteesi: " + this.pisteitaPelaajalla + " / " + (getKierroksenNumero()));
        System.out.println("");
    }
}
