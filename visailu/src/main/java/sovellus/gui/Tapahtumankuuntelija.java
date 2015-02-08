package sovellus.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
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
    private ButtonGroup vaihtoehdot;
    private JRadioButton vaihtoehto1;
    private JRadioButton vaihtoehto2;
    private JRadioButton vaihtoehto3;
    private JRadioButton vaihtoehto4;
    private JRadioButton vaihtoehto5;
    private JButton aloitusnappi;
    private JButton seuraavaKysymys;
    private JLabel kysymyslause;
    private JLabel kysymyssana;
    private JLabel tuloksenIlmoitus;
    private JLabel pistetilanneTeksti;
    private JLabel lopetuslause;

    Tapahtumankuuntelija(Peli peli, Kysymys kysymys, ButtonGroup vaihtoehdot, JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JRadioButton vaihtoehto4, JRadioButton vaihtoehto5, JButton seuraavaKysymys, JLabel kysymyslause, JLabel kysymyssana, JLabel tuloksenIlmoitus, JLabel pistetilanneTeksti, JLabel lopetuslause) {
        this.peli = peli;
        this.kysymys = kysymys;
        this.vaihtoehdot = vaihtoehdot;
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
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(vastaus, this.vaihtoehto1);
        } else if (ae.getSource() == this.vaihtoehto2) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(vastaus, this.vaihtoehto2);
        } else if (ae.getSource() == this.vaihtoehto3) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(vastaus, this.vaihtoehto3);
        } else if (ae.getSource() == this.vaihtoehto4) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(vastaus, this.vaihtoehto4);
        } else if (ae.getSource() == this.vaihtoehto5) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(vastaus, this.vaihtoehto5);
        } else if (ae.getSource() == this.aloitusnappi) {
            this.graafinenKayttis.tyhjennaIkkuna();
            this.graafinenKayttis.teeIkkunaanUusiSisalto();
        } else if (ae.getSource() == this.seuraavaKysymys) {
            this.seuraavaKysymys.setEnabled(false);

            if (this.peli.jatketaankoPelia()) {
                laitaKaikkiVastausvaihtoEhdotPaalle();
                this.peli.vaihdaSeuraavaKysymys();
                this.kysymys = this.peli.getKysymys();
                this.vaihtoehdot.clearSelection();
                this.tuloksenIlmoitus.setText("");

                this.kysymyslause.setText(this.peli.getKierroksenKysymyslause());
                this.kysymyssana.setText(this.kysymys.getKysymyssana());

                ArrayList<String> vastausvaihtoehdot = new ArrayList<String>();

                vastausvaihtoehdot.addAll(this.peli.getVastausvaihtoehdot());

                this.vaihtoehto1.setText(vastausvaihtoehdot.get(0));
                this.vaihtoehto2.setText(vastausvaihtoehdot.get(1));
                this.vaihtoehto3.setText(vastausvaihtoehdot.get(2));
                this.vaihtoehto4.setText(vastausvaihtoehdot.get(3));
                this.vaihtoehto5.setText(vastausvaihtoehdot.get(4));
            } else {
                this.seuraavaKysymys.setEnabled(false);
                String lopetusTeksti = this.peli.pelinLopetusteksti();
                this.lopetuslause.setText(lopetusTeksti);
            }
        }

    }

    private void laitaKaikkiVastausvaihtoEhdotPaalle() {
        this.vaihtoehto1.setEnabled(true);
        this.vaihtoehto2.setEnabled(true);
        this.vaihtoehto3.setEnabled(true);
        this.vaihtoehto4.setEnabled(true);
        this.vaihtoehto5.setEnabled(true);
    }

    private void seuraavaPainikkeenNakyminen() {
        if (this.peli.getKierroksenNumero() >= 8) {
            this.seuraavaKysymys.setEnabled(false);
        }
        this.seuraavaKysymys.setEnabled(true);
    }

    private void vastausJaArviointi(String vastaus, JRadioButton vaihtoehto) {
        vastaus = this.peli.vastauksenArviointi(vaihtoehto.getText());
        this.tuloksenIlmoitus.setText(vastaus);
        this.pistetilanneTeksti.setText(this.peli.pistetilanteenTulostus());
    }
}
