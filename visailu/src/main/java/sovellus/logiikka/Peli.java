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
        this.kysymyssarja = new Kysymyssarja();
        this.kysymys = new Kysymys();
        this.pisteitaPelaajalla = 0;
        this.kierroksenNumero = 1;
    }
    
    public void pelaaKierros() {
        System.out.println("Mikä on ylläolevan valtion pääkaupunki, valitse vaihtoehdoista:");
        annaKysymyssana();
        annaVastausvaihtoehdot();
        
        System.out.print("Kirjoita arvauksesi: ");
        String vastaus = this.lukija.nextLine();
        
        vastauksenArviointi(vastaus);
        
        pistetilanteenTulostus();
        this.kierroksenNumero++;
    }
    
    public boolean onkoVikaKierros() {
        if (this.kierroksenNumero > 20) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getPisteitaPelaajalla() {
        return this.pisteitaPelaajalla;
    }
    
    private void annaKysymyssana() {
        this.kysymys = this.kysymyssarja.getKysymys(this.kierroksenNumero - 1);
        System.out.println(this.kysymyssarja.getKysymys(kierroksenNumero));
        System.out.println(this.kysymys.getKysymyssana().toUpperCase());
        System.out.println("");
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
        //tässä metodissa tarkastetaan pelaajan vastaus
        if (vastaus.toUpperCase().equals(this.kysymys.getOikeaVastaus().toUpperCase())) {
            System.out.println("Hienoa, oikea vastaus!");
            this.pisteitaPelaajalla++;
        } else {
            System.out.println("Nyt meni väärin");
            System.out.println("Oikea vastaus olisi ollut " + this.kysymys.getOikeaVastaus());
        }
    }
    
    private void pistetilanteenTulostus() {
        System.out.println(this.pisteitaPelaajalla + " / " + (this.kierroksenNumero));
        System.out.println("");
    }
}
