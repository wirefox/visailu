package sovellus.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import sovellus.domain.Kysymys;
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
    private Kysymys kysymys;
    private GraafinenKayttoliittyma graafinenKayttis;
    private JRadioButton vaihtoehto1;
    private JRadioButton vaihtoehto2;
    private JRadioButton vaihtoehto3;
    private JRadioButton vaihtoehto4;
    private JRadioButton vaihtoehto5;
    private JButton aloitusnappi;
    private JButton seuraavaKysymys;
    private JLabel kysymyslause;
    private JLabel kysymyssana;
    private JTextArea tuloksenIlmoitus;
    private JTextArea pistetilanneTeksti;
    private JTextArea lopetuslause;

    Tapahtumankuuntelija(Peli peli, Kysymys kysymys, JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JRadioButton vaihtoehto4, JRadioButton vaihtoehto5, JButton seuraavaKysymys, JLabel kysymyslause, JLabel kysymyssana, JTextArea tuloksenIlmoitus, JTextArea pistetilanneTeksti, JTextArea lopetuslause) {
        this.peli = peli;
        this.kysymys = kysymys;
        this.vaihtoehto1 = vaihtoehto1;
        this.vaihtoehto2 = vaihtoehto2;
        this.vaihtoehto3 = vaihtoehto3;
        this.vaihtoehto4 = vaihtoehto4;
        this.vaihtoehto5 = vaihtoehto5;
        this.seuraavaKysymys = seuraavaKysymys;
        this.kysymyslause = kysymyslause;
        this.kysymyssana = kysymyssana;
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
        String vastaus = "aloitus";
        if (ae.getSource() == this.vaihtoehto1) {
            vastaus = this.peli.vastauksenArviointi(this.vaihtoehto1.getText());
            this.tuloksenIlmoitus.setText(vastaus);
            this.pistetilanneTeksti.setText(this.peli.pistetilanteenTulostus());
        } else if (ae.getSource() == this.vaihtoehto2) {
            vastaus = this.peli.vastauksenArviointi(this.vaihtoehto2.getText());
            this.tuloksenIlmoitus.setText(vastaus);
            this.pistetilanneTeksti.setText(this.peli.pistetilanteenTulostus());
        } else if (ae.getSource() == this.vaihtoehto3) {
            vastaus = this.peli.vastauksenArviointi(this.vaihtoehto3.getText());
            this.tuloksenIlmoitus.setText(vastaus);
            this.pistetilanneTeksti.setText(this.peli.pistetilanteenTulostus());
        } else if (ae.getSource() == this.vaihtoehto4) {
            vastaus = this.peli.vastauksenArviointi(this.vaihtoehto4.getText());
            this.tuloksenIlmoitus.setText(vastaus);
            this.pistetilanneTeksti.setText(this.peli.pistetilanteenTulostus());
        } else if (ae.getSource() == this.vaihtoehto5) {
            vastaus = this.peli.vastauksenArviointi(this.vaihtoehto5.getText());
            this.tuloksenIlmoitus.setText(vastaus);
            this.pistetilanneTeksti.setText(this.peli.pistetilanteenTulostus());
        } else if (ae.getSource() == this.aloitusnappi) {
            this.graafinenKayttis.tyhjennaIkkuna();
            this.graafinenKayttis.teeIkkunaanUusiSisalto();
        } else if (ae.getSource() == this.seuraavaKysymys) {
            if (this.peli.jatketaankoPelia()) {
                this.peli.vaihdaSeuraavaKysymys();
                this.kysymys = this.peli.getKysymys();

                this.kysymyslause.setText(this.peli.getKierroksenKysymyslause());
                this.kysymyssana.setText(this.kysymys.getKysymyssana());

                ArrayList<String> vastausvaihtoehdot = new ArrayList<String>();

                vastausvaihtoehdot.addAll(this.peli.getVastausvaihtoehdot());

                this.vaihtoehto1.setText(vastausvaihtoehdot.get(0));
                this.vaihtoehto2.setText(vastausvaihtoehdot.get(1));
                this.vaihtoehto3.setText(vastausvaihtoehdot.get(2));
                this.vaihtoehto4.setText(vastausvaihtoehdot.get(3));
                this.vaihtoehto5.setText(vastausvaihtoehdot.get(4));
            }
        } else {
            String lopetusTeksti = this.peli.pelinLopetusteksti();
            this.lopetuslause.setText(lopetusTeksti);
        }
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }
    }
}
