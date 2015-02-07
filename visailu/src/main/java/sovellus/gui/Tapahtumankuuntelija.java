package sovellus.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import sovellus.logiikka.Peli;

/**
 * Luokka kertoo minkä vastausvaihtoehdon pelaaja valitsi ja käskyttää sitten
 * muita tahoja tekemään asioita (mm vastauksen analysointi, piste- ja
 * kierrostilanne, uusi kierros, ikkunan päivitys) - Luokka on hyvin
 * keskeneräinen vielä
 *
 * @author elina
 */
public class Tapahtumankuuntelija implements ActionListener {
    
    private Peli peli;
    private GraafinenKayttoliittyma graafinenKayttis;
    private JRadioButton vaihtoehto1;
    private JRadioButton vaihtoehto2;
    private JRadioButton vaihtoehto3;
    private JRadioButton vaihtoehto4;
    private JRadioButton vaihtoehto5;
    private JButton aloitusnappi;
    private JTextArea tuloksenIlmoitus;
    private JTextArea pistetilanneTeksti;
    private JTextArea lopetuslause;
    
    Tapahtumankuuntelija(Peli peli, JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JRadioButton vaihtoehto4, JRadioButton vaihtoehto5, JTextArea tuloksenIlmoitus, JTextArea PisteTilanneTeksti, JTextArea lopetuslause) {
        this.peli = peli;
        this.vaihtoehto1 = vaihtoehto1;
        this.vaihtoehto2 = vaihtoehto2;
        this.vaihtoehto3 = vaihtoehto3;
        this.vaihtoehto4 = vaihtoehto4;
        this.vaihtoehto5 = vaihtoehto5;
        this.tuloksenIlmoitus = tuloksenIlmoitus;
        this.pistetilanneTeksti = pistetilanneTeksti;
        this.lopetuslause = lopetuslause;
    }
    
    Tapahtumankuuntelija(GraafinenKayttoliittyma graafinenKayttis, JButton nappi) {
        this.graafinenKayttis = graafinenKayttis;
        this.aloitusnappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String vastaus = "";
        if (ae.getSource() == vaihtoehto1) {
            System.out.println("vaihtoehto 1 valittu");
            vastaus = this.peli.vastauksenArviointi(vaihtoehto1.getText());
        } else if (ae.getSource() == vaihtoehto2) {
            System.out.println("vaihtoehto 2 valittu");
            vastaus = this.peli.vastauksenArviointi(vaihtoehto2.getText());
        } else if (ae.getSource() == vaihtoehto3) {
            System.out.println("vaihtoehto 3 valittu");
            vastaus = this.peli.vastauksenArviointi(vaihtoehto3.getText());
        } else if (ae.getSource() == vaihtoehto4) {
            System.out.println("vaihtoehto 4 valittu");
            vastaus = this.peli.vastauksenArviointi(vaihtoehto4.getText());
        } else if (ae.getSource() == vaihtoehto5) {
            System.out.println("vaihtoehto 5 valittu");
            vastaus = this.peli.vastauksenArviointi(vaihtoehto5.getText());
        } else if (ae.getSource() == aloitusnappi) {
            this.graafinenKayttis.tyhjennaIkkuna();
            this.graafinenKayttis.teeIkkunaanUusiSisalto();
        }
        
        this.tuloksenIlmoitus.setText(vastaus);
        this.pistetilanneTeksti.setText(this.peli.pistetilanteenTulostus());
        
        if (this.peli.jatketaankoPelia()) {
            this.peli.vaihdaSeuraavaKysymys();
        } else {
            String lopetusTeksti = this.peli.pelinLopetusteksti();
            this.lopetuslause.setText(lopetusTeksti);
        }
    }
}
