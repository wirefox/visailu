package sovellus.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import sovellus.domain.Kysymys;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Visailukoordinaattori;

public class Tapahtumankuuntelija implements ActionListener {
    
    private Peli peli;
    private Visailukoordinaattori visailukoordinaattori;
    private GraafinenKayttoliittyma graafinenKayttis;
    private JRadioButton paakaupunkiVisa;
    private JRadioButton kiinaNumeroVisa;
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
    private boolean paakaupunkiPeliValittu;
    private boolean kiinaNumeroVisaValittu;

    /**
     * Konstruktori luo aloitusnäkymän tapahtumankuuntelijan
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
        this.pistetilanneTeksti = pistetilanneTeksti;
        this.lopetuslause = lopetuslause;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
//Aloitusikkunan toimenpiteet; pelaaja valitsee pelin ja aloittaa pelaamisen:
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
                this.visailukoordinaattori.pelinValmistelutoimet(this.graafinenKayttis, this.paakaupunkiVisa.getText());
            } else if (this.kiinaNumeroVisaValittu) {
                this.graafinenKayttis.tyhjennaIkkuna();
                this.visailukoordinaattori.pelinValmistelutoimet(this.graafinenKayttis, this.kiinaNumeroVisa.getText());
                
            }

//Peli-ikkunan toimenpiteet; pelaaja pelaa peliä kierros kierrokselta:    
        } else if (ae.getSource() == this.vaihtoehto1) {
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(this.vaihtoehto1);
        } else if (ae.getSource() == this.vaihtoehto2) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(this.vaihtoehto2);
        } else if (ae.getSource() == this.vaihtoehto3) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(this.vaihtoehto3);
        } else if (ae.getSource() == this.vaihtoehto4) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto5.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(this.vaihtoehto4);
        } else if (ae.getSource() == this.vaihtoehto5) {
            this.vaihtoehto1.setEnabled(false);
            this.vaihtoehto2.setEnabled(false);
            this.vaihtoehto3.setEnabled(false);
            this.vaihtoehto4.setEnabled(false);
            seuraavaPainikkeenNakyminen();
            vastausJaArviointi(this.vaihtoehto5);

//Peli-ikkunan seuraava-painike ja pelin kierrosten pyörittäminen:
        } else if (ae.getSource() == this.seuraavaKysymys) {
            this.seuraavaKysymys.setEnabled(false);
            
            if (this.peli.jatketaankoPelia()) {
                laitaKaikkiVastausvaihtoEhdotMustaksiJaPaalle();
                this.peli.vaihdaSeuraavaKysymys();
                this.vaihtoehdot.clearSelection();
                this.tuloksenIlmoitus.setText("");
                this.pistetilanneTeksti.setText("");
                
                this.kysymyslause.setText(this.peli.getKierroksenKysymyslause());
                this.kysymyssana.setText(this.peli.getKysymys().getKysymyssana());
                kierroksenVaihtoehdot();
            } else {
                this.seuraavaKysymys.setEnabled(false);
                String lopetusTeksti = this.peli.pelinLopetusteksti();
                this.lopetuslause.setText(lopetusTeksti);
            }
        }
    }

    /**
     * Metodi asettaa ikkunan JRadioButtoneille kierroksen vastausvaihtoehdot.
     *
     */
    private void kierroksenVaihtoehdot() {
        ArrayList<String> vastausvaihtoehdot = new ArrayList<String>();
        
        vastausvaihtoehdot.addAll(this.peli.muodostaVastausvaihtoehdot());
        
        this.vaihtoehto1.setText(vastausvaihtoehdot.get(0));
        this.vaihtoehto2.setText(vastausvaihtoehdot.get(1));
        this.vaihtoehto3.setText(vastausvaihtoehdot.get(2));
        this.vaihtoehto4.setText(vastausvaihtoehdot.get(3));
        this.vaihtoehto5.setText(vastausvaihtoehdot.get(4));
    }

    /**
     * Metodi asettaa ikkunan JRadioButton-vastausvaihtoehdot valmiiksi
     * vastaamista varten.
     *
     */
    private void laitaKaikkiVastausvaihtoEhdotMustaksiJaPaalle() {
        Collection<JRadioButton> nappiLista = new ArrayList<JRadioButton>();
        nappiLista.add(this.vaihtoehto1);
        nappiLista.add(this.vaihtoehto2);
        nappiLista.add(this.vaihtoehto3);
        nappiLista.add(this.vaihtoehto4);
        nappiLista.add(this.vaihtoehto5);
        
        Font perusfontti = new Font("Dialog", 1, 12);
        
        for (JRadioButton nappi : nappiLista) {
            nappi.setForeground(Color.BLACK);
            nappi.setFont(perusfontti);
            nappi.setEnabled(true);
        }
    }

    /**
     * Metodi määrittelee pelin kierroksen numeron perusteella pitääkö seuraava
     * kysymys -painike olla päällä.
     *
     * Tässä metodissa on mahdollisesti korjattavaa (voisiko esim. yhdistää
     * pelin boolean-metodiin??)
     */
    private void seuraavaPainikkeenNakyminen() {
        if (this.peli.getKierroksenNumero() >= 8) {
            this.seuraavaKysymys.setEnabled(false);
        }
        this.seuraavaKysymys.setEnabled(true);
    }

    /**
     * Metodissa arvioidaan pelaajan valitsema vastaus.
     *
     * Jos vastaus on oikein, muutetaan fontin väri vihreäksi, jos väärin,
     * muutetaan fontin väri punaiseksi.
     *
     * @param vaihtoehto
     */
    private void vastausJaArviointi(JRadioButton vaihtoehto) {
        String vastaus = this.peli.vastauksenArviointi(vaihtoehto.getText());
        if (this.peli.getKysymys().onkoOikeaVastaus(vaihtoehto.getText())) {
            vaihtoehto.setForeground(Color.GREEN);
        } else {
            vaihtoehto.setForeground(Color.RED);
            paikallistaOikeaVastausvaihtoehtoJaAlleviivaa();
        }
        this.tuloksenIlmoitus.setText(vastaus);
        this.pistetilanneTeksti.setText(this.peli.pistetilanneTeksti());
        this.peli.kasvataKierroksenNumeroa();
    }

    /**
     * Jos pelaaja vastannut väärin, paikallistetaan metodissa oikea vastaus ja
     * alleviivataan se.
     */
    private void paikallistaOikeaVastausvaihtoehtoJaAlleviivaa() {
        
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
