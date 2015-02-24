package sovellus.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Visailukoordinaattori;

/**
 * Luokassa luodaan tapahtumankuuntelija, joka seuraa pelaajan valintoja.
 *
 * @author elina
 */
public class Tapahtumankuuntelija implements ActionListener {

    private Peli peli;
    private Visailukoordinaattori visailukoordinaattori;
    private GraafinenKayttoliittyma graafinenKayttis;
    private JRadioButton paakaupunkiVisa, kiinaNumeroVisa;
    private ButtonGroup vaihtoehdot;
    private JRadioButton vaihtoehto1, vaihtoehto2, vaihtoehto3, vaihtoehto4, vaihtoehto5;
    private JButton aloitusnappi, seuraavaKysymys;
    private JLabel kysymyslause, kysymyssana, tuloksenIlmoitus, pistetilanne, lopetuslause;
    private boolean paakaupunkiPeliValittu, kiinaNumeroVisaValittu;

    /**
     * Konstruktori luo aloitusnäkymän tapahtumankuuntelijan.
     *
     * Aloitusnäkymässä pelaaja valitsee pelin, jota haluaa pelata.
     *
     * @param graafinenKayttis
     * @param visailukoordinaattori
     * @param paakaupunkiVisa
     * @param kiinaNumeroVisa
     * @param aloitusnappi
     */
    public Tapahtumankuuntelija(GraafinenKayttoliittyma graafinenKayttis, Visailukoordinaattori visailukoordinaattori, JRadioButton paakaupunkiVisa, JRadioButton kiinaNumeroVisa, JButton aloitusnappi) {
        this.graafinenKayttis = graafinenKayttis;
        this.visailukoordinaattori = visailukoordinaattori;
        this.paakaupunkiVisa = paakaupunkiVisa;
        this.kiinaNumeroVisa = kiinaNumeroVisa;
        this.aloitusnappi = aloitusnappi;
        this.kiinaNumeroVisaValittu = false;
        this.paakaupunkiPeliValittu = false;
    }

    /**
     * Konstruktori luo pelinäkymän tapahtumankuuntelijan.
     *
     * @param peli
     * @param vaihtoehdot
     * @param vaihtoehto1
     * @param vaihtoehto2
     * @param vaihtoehto3
     * @param vaihtoehto4
     * @param vaihtoehto5
     * @param seuraavaKysymys
     * @param kysymyslause
     * @param kysymyssana
     * @param pistetilanneTeksti
     * @param tuloksenIlmoitus
     * @param lopetuslause
     */
    public Tapahtumankuuntelija(Peli peli, ButtonGroup vaihtoehdot, JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JRadioButton vaihtoehto4, JRadioButton vaihtoehto5, JButton seuraavaKysymys, JLabel kysymyslause, JLabel kysymyssana, JLabel tuloksenIlmoitus, JLabel pistetilanneTeksti, JLabel lopetuslause) {
        this.peli = peli;
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
        this.pistetilanne = pistetilanneTeksti;
        this.lopetuslause = lopetuslause;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.paakaupunkiVisa || ae.getSource() == this.kiinaNumeroVisa || ae.getSource() == this.aloitusnappi) {
            pelinAloitusikkunanToimenpiteet(ae);
        } else if (ae.getSource() == this.vaihtoehto1 || ae.getSource() == this.vaihtoehto2 || ae.getSource() == this.vaihtoehto3 || ae.getSource() == this.vaihtoehto4 || ae.getSource() == this.vaihtoehto5) {
            peliIkkunanToimenpiteet(ae);
        } else {
            pelinEtenemistoimenpiteet(ae);
        }
    }

    private void pelinAloitusikkunanToimenpiteet(ActionEvent ae) {
        if (ae.getSource() == this.paakaupunkiVisa) {
            this.aloitusnappi.setEnabled(true);
            this.paakaupunkiPeliValittu = true;
            this.kiinaNumeroVisaValittu = false;
        } else if (ae.getSource() == this.kiinaNumeroVisa) {
            this.aloitusnappi.setEnabled(true);
            this.kiinaNumeroVisaValittu = true;
            this.paakaupunkiPeliValittu = false;
        } else if (ae.getSource() == this.aloitusnappi) {
            if (this.paakaupunkiPeliValittu) {
                this.graafinenKayttis.tyhjennaIkkuna();
                this.visailukoordinaattori.lueTiedosto(this.paakaupunkiVisa.getText());
                this.peli = new Peli(this.visailukoordinaattori.muodostaKysymyssarja());
                this.graafinenKayttis.luoKomponentitPeliIkkunaan(this.graafinenKayttis.getFrame().getContentPane(), this.peli);
            } else if (this.kiinaNumeroVisaValittu) {
                this.graafinenKayttis.tyhjennaIkkuna();
                this.visailukoordinaattori.lueTiedosto(this.kiinaNumeroVisa.getText());
                this.peli = new Peli(this.visailukoordinaattori.muodostaKysymyssarja());
                this.graafinenKayttis.luoKomponentitPeliIkkunaan(this.graafinenKayttis.getFrame().getContentPane(), this.peli);
            }
        }
    }

    private void peliIkkunanToimenpiteet(ActionEvent ae) {
        lukitseValinta(ae);
        this.seuraavaKysymys.setEnabled(true);
        vastausJaArviointi(ae);
    }

    private void pelinEtenemistoimenpiteet(ActionEvent ae) {
        if (ae.getSource() == this.seuraavaKysymys) {
            this.seuraavaKysymys.setEnabled(false);

            if (this.peli.jatketaankoPelia()) {
                muutaVaihtoehtojenFonttiNormaaliksi();
                this.peli.vaihdaSeuraavaKysymys();
                this.vaihtoehdot.clearSelection();
                this.tuloksenIlmoitus.setText("");
                this.pistetilanne.setText("");
                this.kysymyslause.setText(this.peli.getKierroksenKysymyslause());
                this.kysymyssana.setText(this.peli.getKysymys().getKysymyssana());
                laitaKierroksenVaihtoehdot();
            } else {
                this.seuraavaKysymys.setVisible(false);
                String lopetusTeksti = this.peli.pelinLopetusteksti();
                this.lopetuslause.setText(lopetusTeksti);
            }
        }
    }

    /**
     * Metodissa lukitaan muut vaihtoehdot, kun pelaaja on vastannut.
     */
    private void lukitseValinta(ActionEvent ae) {
        for (Enumeration<AbstractButton> e = this.vaihtoehdot.getElements(); e.hasMoreElements();) {
            JRadioButton nappi = (JRadioButton) e.nextElement();
            nappi.setEnabled(nappi.equals(ae.getSource()));
        }
    }

    /**
     * Metodissa laitetaan kierrokselle uudet vastausvaihtoehdot.
     */
    private void laitaKierroksenVaihtoehdot() {
        ArrayList<String> vastausvaihtoehdot = new ArrayList<>();
        vastausvaihtoehdot.addAll(this.peli.muodostaVastausvaihtoehdot());
        this.vaihtoehto1.setText(vastausvaihtoehdot.get(0));
        this.vaihtoehto2.setText(vastausvaihtoehdot.get(1));
        this.vaihtoehto3.setText(vastausvaihtoehdot.get(2));
        this.vaihtoehto4.setText(vastausvaihtoehdot.get(3));
        this.vaihtoehto5.setText(vastausvaihtoehdot.get(4));
    }

    /**
     * Metodissa muutetaan vaihtoehtojen fontti kierroksen alussa normaaliksi.
     */
    private void muutaVaihtoehtojenFonttiNormaaliksi() {
        Font perusfontti = new Font("Dialog", 1, 12);
        for (Enumeration<AbstractButton> e = this.vaihtoehdot.getElements(); e.hasMoreElements();) {
            JRadioButton nappi = (JRadioButton) e.nextElement();
            nappi.setForeground(Color.BLACK);
            nappi.setFont(perusfontti);
            nappi.setEnabled(true);
        }
    }

    /**
     * Metodissa arvioidaan pelaajan valitsema vastaus.
     *
     * Jos vastaus on oikein, muutetaan fontin väri vihreäksi, jos väärin,
     * muutetaan fontin väri punaiseksi ja alleviivataan oikea vastaus.
     *
     * @param ae ActionEvent
     */
    private void vastausJaArviointi(ActionEvent ae) {
        JRadioButton vaihtoehto = (JRadioButton) ae.getSource();
        String vastaus = this.peli.vastauksenArviointi(vaihtoehto.getText());
        if (this.peli.getKysymys().onkoOikeaVastaus(vaihtoehto.getText())) {
            vaihtoehto.setForeground(Color.GREEN);
        } else {
            vaihtoehto.setForeground(Color.RED);
            alleviivaaOikeaVastaus();
        }
        this.tuloksenIlmoitus.setText(vastaus);
        this.pistetilanne.setText(this.peli.pistetilanneTeksti());
        this.peli.kasvataKierroksenNumeroa();
    }

    /**
     * Jos pelaaja vastannut väärin, etsitään oikea vastaus ja alleviivataan se.
     */
    private void alleviivaaOikeaVastaus() {

        Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        Font alleviivaus = new Font("Dialog", Font.BOLD, 12).deriveFont(fontAttributes);

        String oikeaVastaus = this.peli.getKysymys().getOikeaVastaus();
        if (this.vaihtoehto1.getText().equals(oikeaVastaus)) {
            this.vaihtoehto1.setFont(alleviivaus);
        } else if (this.vaihtoehto2.getText().equals(oikeaVastaus)) {
            this.vaihtoehto2.setFont(alleviivaus);
        } else if (this.vaihtoehto3.getText().equals(oikeaVastaus)) {
            this.vaihtoehto3.setFont(alleviivaus);
        } else if (this.vaihtoehto4.getText().equals(oikeaVastaus)) {
            this.vaihtoehto4.setFont(alleviivaus);
        } else if (this.vaihtoehto5.getText().equals(oikeaVastaus)) {
            this.vaihtoehto5.setFont(alleviivaus);
        }
    }
}
