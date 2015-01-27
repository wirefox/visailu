package sovellus.gui;

import java.util.ArrayList;
import java.util.Scanner;
import sovellus.logiikka.Visailukoordinaattori;

public class Tekstikayttoliittyma {

    private Scanner lukija;

    public Tekstikayttoliittyma() {
        this.lukija = new Scanner(System.in);
    }

    public void aloitaVisailu() {
        System.out.println("Hei, tervetuloa visailuun!\n");
    }

    public void tulosta(String teksti) {
        System.out.println(teksti);
    }

    public void tulostaVastausvaihtoehdot(ArrayList<String> vastausvaihtoehdot) {
        System.out.println("");
        for (String paakaupunki : vastausvaihtoehdot) {
            System.out.println(paakaupunki);
        }
    }

    public String otaVastaus(String teksti) {
        System.out.print(teksti);
        String vastaus = this.lukija.nextLine();
        return vastaus;
    }
}
