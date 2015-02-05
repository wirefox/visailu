package sovellus.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import sovellus.domain.Kysymys;
import sovellus.domain.Kysymyssarja;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Visailukoordinaattori;

/**
 * Luokka pn visailun alustava käyttöliittymä, joka toimii komentorivin kautta
 */
public class Tekstikayttoliittyma {

    private Peli peli;
    private Scanner lukija;
    private Kysymys kysymys;

    public Tekstikayttoliittyma(Peli peli) {
        this.peli = peli;
        this.lukija = new Scanner(System.in);
        johdaPelia();
    }

    public void johdaPelia() {

        while (true) {
            this.peli.vaihdaSeuraavaKysymys();
            this.kysymys = this.peli.getKysymys();
            pelaaKierros();
            if (!this.peli.jatketaankoPelia()) {
                tulostaNaytolle(this.peli.pelinLopetusteksti());
                return;
            }
        }
    }

    private void pelaaKierros() {
        tulostaNaytolle(this.peli.getKierroksenKysymyslause());
        tulostaNaytolle(this.kysymys.getKysymyssana());
        tulostaNaytolle(getVastausvaihtoehdot());
        String vastaus = otaVastaus("\nKirjoita arvauksesi: ");
        tulostaNaytolle(this.peli.vastauksenArviointi(vastaus));
        tulostaNaytolle(this.peli.pistetilanteenTulostus());
    }

    public ArrayList<String> getVastausvaihtoehdot() {
        ArrayList<String> vastausvaihtoehdot = this.kysymys.getVaaratVastaukset();
        vastausvaihtoehdot.add(this.kysymys.getOikeaVastaus());
        Collections.shuffle(vastausvaihtoehdot);
        return vastausvaihtoehdot;
    }

    public void tulostaNaytolle(String teksti) {
        System.out.println(teksti);
    }

    public void tulostaNaytolle(ArrayList<String> vastausvaihtoehdot) {
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
