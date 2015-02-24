package sovellus.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Visailukoordinaattori;

/**
 * Luokassa luodaan pelin graafinen käyttöliittymä: ikkuna, jossa alussa pelin
 * aloitusnäkymä, ja pelin valinan jälkeen pelinäkymä.
 *
 * @author elina
 */
public class GraafinenKayttoliittyma implements Runnable {

    private Visailukoordinaattori visailukoordinaattori;
    private Peli peli;
    private JFrame frame;

    public GraafinenKayttoliittyma(Visailukoordinaattori visailukoordinaattori) {
        this.visailukoordinaattori = visailukoordinaattori;
    }

    public GraafinenKayttoliittyma(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        this.frame = new JFrame("       Visailu");
        this.frame.setPreferredSize(new Dimension(700, 400));

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentitAloitusikkunaan(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }

    /**
     * Metodi luo komponentit ja tapahtumankuuntelijan pelin aloitusikkunaan,
     * jossa pelaaja valitsee pelin.
     *
     * @param container-olio
     */
    private void luoKomponentitAloitusikkunaan(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(Box.createRigidArea(new Dimension(60, 60)));

        JLabel tervetuloaTeksti = new JLabel("Tervetuloa oppimaan!");
        lisaaJLabelJaRiveja(container, tervetuloaTeksti, 60, 10);

        JLabel valintaTeksti = new JLabel("Valitse peli, jota haluat pelata:");
        lisaaJLabelJaRiveja(container, valintaTeksti, 60, 10);

        ButtonGroup pelinValinta = new ButtonGroup();
        JRadioButton paakaupunkiPeli = new JRadioButton("valtiot ja pääkaupungit");
        JRadioButton kiinaNumeroPeli = new JRadioButton("kiinan numerot");
        lisaaJRadioButton(container, pelinValinta, paakaupunkiPeli);
        lisaaJRadioButton(container, pelinValinta, kiinaNumeroPeli);
        container.add(Box.createRigidArea(new Dimension(60, 30)));

        JButton aloitusNappi = new JButton("Aloita peli");
        lisaaJButton(container, aloitusNappi, "aloita peli", false, 0, 0);

        Tapahtumankuuntelija tapahtumankuuntelija = new Tapahtumankuuntelija(this, this.visailukoordinaattori, paakaupunkiPeli, kiinaNumeroPeli, aloitusNappi);
        aloitusNappi.addActionListener(tapahtumankuuntelija);
        paakaupunkiPeli.addActionListener(tapahtumankuuntelija);
        kiinaNumeroPeli.addActionListener(tapahtumankuuntelija);
    }

    /**
     * Metodi luo ikkunaan uudet komponentit ja tapahtumankuuntelijan, jotta
     * pelin pelaus voi alkaa
     *
     * @param container-olio
     * @param peli-olio
     */
    public void luoKomponentitPeliIkkunaan(Container container, Peli peli) {
        this.peli = peli;
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(Box.createRigidArea(new Dimension(60, 20)));

        JLabel kysymyslause = new JLabel();
        lisaaJLabelJaRiveja(container, kysymyslause, 60, 20);
        JLabel kysymyssana = new JLabel();
        lisaaJLabelJaRiveja(container, kysymyssana, 60, 20);

        ButtonGroup vaihtoehdot = new ButtonGroup();
        JRadioButton vaihtoehto1 = new JRadioButton();
        JRadioButton vaihtoehto2 = new JRadioButton();
        JRadioButton vaihtoehto3 = new JRadioButton();
        JRadioButton vaihtoehto4 = new JRadioButton();
        JRadioButton vaihtoehto5 = new JRadioButton();
        lisaaJRadioButton(container, vaihtoehdot, vaihtoehto1);
        lisaaJRadioButton(container, vaihtoehdot, vaihtoehto2);
        lisaaJRadioButton(container, vaihtoehdot, vaihtoehto3);
        lisaaJRadioButton(container, vaihtoehdot, vaihtoehto4);
        lisaaJRadioButton(container, vaihtoehdot, vaihtoehto5);
        container.add(Box.createRigidArea(new Dimension(60, 20)));

        JLabel tuloksenIlmoitus = new JLabel();
        lisaaJLabelJaRiveja(container, tuloksenIlmoitus, 60, 20);

        JLabel pistetilanneTeksti = new JLabel();
        lisaaJLabelJaRiveja(container, pistetilanneTeksti, 60, 20);

        JButton seuraavaKysymys = new JButton("Seuraava kysymys");
        lisaaJButton(container, seuraavaKysymys, "seuraava kysymys", false, 60, 20);
        container.add(Box.createRigidArea(new Dimension(60, 20)));

        JLabel lopetuslause = new JLabel();
        lisaaJLabelJaRiveja(container, lopetuslause, 60, 20);
        lopetuslause.setText("");

        this.peli.vaihdaSeuraavaKysymys();

        Tapahtumankuuntelija tapahtumanKuuntelija = new Tapahtumankuuntelija(this.peli, vaihtoehdot, vaihtoehto1, vaihtoehto2, vaihtoehto3, vaihtoehto4, vaihtoehto5, seuraavaKysymys, kysymyslause, kysymyssana, tuloksenIlmoitus, pistetilanneTeksti, lopetuslause);
        vaihtoehto1.addActionListener(tapahtumanKuuntelija);
        vaihtoehto2.addActionListener(tapahtumanKuuntelija);
        vaihtoehto3.addActionListener(tapahtumanKuuntelija);
        vaihtoehto4.addActionListener(tapahtumanKuuntelija);
        vaihtoehto5.addActionListener(tapahtumanKuuntelija);
        seuraavaKysymys.addActionListener(tapahtumanKuuntelija);

        asetaEkanKierroksenKysymysJaVastaukset(kysymyslause, kysymyssana, vaihtoehto1, vaihtoehto2, vaihtoehto3, vaihtoehto4, vaihtoehto5);

        frame.setVisible(true);
    }

    private void asetaEkanKierroksenKysymysJaVastaukset(JLabel kysymyslause, JLabel kysymyssana, JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JRadioButton vaihtoehto4, JRadioButton vaihtoehto5) {
        kysymyslause.setText(this.peli.getKierroksenKysymyslause());
        kysymyssana.setText(this.peli.getKysymys().getKysymyssana());

        ArrayList<String> vastausvaihtoehdot = new ArrayList<String>();

        vastausvaihtoehdot.addAll(this.peli.muodostaVastausvaihtoehdot());

        vaihtoehto1.setText(vastausvaihtoehdot.get(0));
        vaihtoehto2.setText(vastausvaihtoehdot.get(1));
        vaihtoehto3.setText(vastausvaihtoehdot.get(2));
        vaihtoehto4.setText(vastausvaihtoehdot.get(3));
        vaihtoehto5.setText(vastausvaihtoehdot.get(4));
    }

    void tyhjennaIkkuna() {
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().repaint();
    }

    public JFrame getFrame() {
        return this.frame;
    }

    private void lisaaJLabelJaRiveja(Container container, JLabel teksti, int tyhjaaLeveys, int tyhjaaKorkeus) {
        container.add(teksti);
        container.add(Box.createRigidArea(new Dimension(tyhjaaLeveys, tyhjaaKorkeus)));
    }

    private void lisaaJRadioButton(Container container, ButtonGroup pelinValinta, JRadioButton peli) {
        pelinValinta.add(peli);
        container.add(peli);
    }

    private void lisaaJButton(Container container, JButton nappi, String teksti, boolean paalla, int tyhjaaLeveys, int tyhjaaKorkeus) {
        nappi.setToolTipText(teksti);
        nappi.setEnabled(paalla);
        container.add(nappi);
        container.add(Box.createRigidArea(new Dimension(tyhjaaLeveys, tyhjaaKorkeus)));
    }
}
