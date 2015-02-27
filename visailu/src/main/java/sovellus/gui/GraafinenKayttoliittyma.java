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
 * Luokka luo pelin graafisen käyttöliittymän: ikkuna, jossa alussa pelin
 * aloitusnäkymä, ja pelin valinan jälkeen pelinäkymä.
 *
 * @author elina
 */
public class GraafinenKayttoliittyma implements Runnable {

    private Visailukoordinaattori visailukoordinaattori;
    private JFrame frame;

    /**
     * Konstruktori luo graafinenKayttoliittyma-olion.
     *
     * @param visailukoordinaattori Saa visailukoordinaattoriolion.
     */
    public GraafinenKayttoliittyma(Visailukoordinaattori visailukoordinaattori) {
        this.visailukoordinaattori = visailukoordinaattori;
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
        lisaaJLabelJaRiveja(tervetuloaTeksti, 60, 10);

        JLabel valintaTeksti = new JLabel("Valitse peli, jota haluat pelata:");
        lisaaJLabelJaRiveja(valintaTeksti, 60, 10);

        ButtonGroup pelinValinta = new ButtonGroup();
        JRadioButton paakaupunkiPeli = new JRadioButton("valtiot ja pääkaupungit");
        JRadioButton kiinaNumeroPeli = new JRadioButton("kiinan numerot");
        lisaaJRadioButton(pelinValinta, paakaupunkiPeli);
        lisaaJRadioButton(pelinValinta, kiinaNumeroPeli);
        container.add(Box.createRigidArea(new Dimension(60, 30)));

        JButton aloitusNappi = new JButton("Aloita peli");
        lisaaJButton(aloitusNappi, "aloita peli", false, 0, 0);

        Tapahtumankuuntelija tapahtumankuuntelija = new Tapahtumankuuntelija(this, this.visailukoordinaattori, paakaupunkiPeli, kiinaNumeroPeli, aloitusNappi);
        aloitusNappi.addActionListener(tapahtumankuuntelija);
        paakaupunkiPeli.addActionListener(tapahtumankuuntelija);
        kiinaNumeroPeli.addActionListener(tapahtumankuuntelija);
    }

    /**
     * Metodi luo ikkunaan uudet komponentit ja tapahtumankuuntelijan, jotta
     * pelin pelaus voi alkaa.
     *
     * @param peli-olio
     */
    public void luoKomponentitPeliIkkunaanJaAlustaEkaKierros(Peli peli) {
        BoxLayout layout = new BoxLayout(this.getFrame().getContentPane(), BoxLayout.Y_AXIS);
        this.getFrame().getContentPane().setLayout(layout);
        this.getFrame().getContentPane().add(Box.createRigidArea(new Dimension(60, 20)));

        JLabel kysymyslause = new JLabel();
        lisaaJLabelJaRiveja(kysymyslause, 60, 20);
        JLabel kysymyssana = new JLabel();
        lisaaJLabelJaRiveja(kysymyssana, 60, 20);

        ButtonGroup vaihtoehdot = new ButtonGroup();
        JRadioButton vaihtoehto1 = new JRadioButton();
        JRadioButton vaihtoehto2 = new JRadioButton();
        JRadioButton vaihtoehto3 = new JRadioButton();
        JRadioButton vaihtoehto4 = new JRadioButton();
        JRadioButton vaihtoehto5 = new JRadioButton();
        lisaaJRadioButton(vaihtoehdot, vaihtoehto1);
        lisaaJRadioButton(vaihtoehdot, vaihtoehto2);
        lisaaJRadioButton(vaihtoehdot, vaihtoehto3);
        lisaaJRadioButton(vaihtoehdot, vaihtoehto4);
        lisaaJRadioButton(vaihtoehdot, vaihtoehto5);
        this.getFrame().getContentPane().add(Box.createRigidArea(new Dimension(60, 20)));

        JLabel tuloksenIlmoitus = new JLabel();
        lisaaJLabelJaRiveja(tuloksenIlmoitus, 60, 20);

        JLabel pistetilanneTeksti = new JLabel();
        lisaaJLabelJaRiveja(pistetilanneTeksti, 60, 20);

        JButton seuraavaKysymys = new JButton("Seuraava kysymys");
        lisaaJButton(seuraavaKysymys, "seuraava kysymys", false, 60, 20);
        this.getFrame().getContentPane().add(Box.createRigidArea(new Dimension(60, 20)));

        JLabel lopetuslause = new JLabel();
        lisaaJLabelJaRiveja(lopetuslause, 60, 20);
        lopetuslause.setText("");

        Tapahtumankuuntelija tapahtumanKuuntelija = new Tapahtumankuuntelija(peli, vaihtoehdot, vaihtoehto1, vaihtoehto2, vaihtoehto3, vaihtoehto4, vaihtoehto5, seuraavaKysymys, kysymyslause, kysymyssana, tuloksenIlmoitus, pistetilanneTeksti, lopetuslause);
        vaihtoehto1.addActionListener(tapahtumanKuuntelija);
        vaihtoehto2.addActionListener(tapahtumanKuuntelija);
        vaihtoehto3.addActionListener(tapahtumanKuuntelija);
        vaihtoehto4.addActionListener(tapahtumanKuuntelija);
        vaihtoehto5.addActionListener(tapahtumanKuuntelija);
        seuraavaKysymys.addActionListener(tapahtumanKuuntelija);

        asetaEkanKierroksenKysymysJaVastaukset(peli, kysymyslause, kysymyssana, vaihtoehto1, vaihtoehto2, vaihtoehto3, vaihtoehto4, vaihtoehto5);

        frame.setVisible(true);
    }

    private void asetaEkanKierroksenKysymysJaVastaukset(Peli peli, JLabel kysymyslause, JLabel kysymyssana, JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JRadioButton vaihtoehto4, JRadioButton vaihtoehto5) {
        peli.vaihdaSeuraavaKysymys();
        kysymyslause.setText(peli.getKierroksenKysymyslause());
        kysymyssana.setText(peli.getKysymys().getKysymyssana());

        ArrayList<String> vastausvaihtoehdot = new ArrayList<>();

        vastausvaihtoehdot.addAll(peli.muodostaVastausvaihtoehdot());

        vaihtoehto1.setText(vastausvaihtoehdot.get(0));
        vaihtoehto2.setText(vastausvaihtoehdot.get(1));
        vaihtoehto3.setText(vastausvaihtoehdot.get(2));
        vaihtoehto4.setText(vastausvaihtoehdot.get(3));
        vaihtoehto5.setText(vastausvaihtoehdot.get(4));
    }

    void tyhjennaIkkuna() {
        getFrame().getContentPane().removeAll();
        getFrame().getContentPane().repaint();
    }

    public JFrame getFrame() {
        return this.frame;
    }

    private void lisaaJLabelJaRiveja(JLabel teksti, int tyhjaaLeveys, int tyhjaaKorkeus) {
        getFrame().getContentPane().add(teksti);
        getFrame().getContentPane().add(Box.createRigidArea(new Dimension(tyhjaaLeveys, tyhjaaKorkeus)));
    }

    private void lisaaJRadioButton(ButtonGroup pelinValinta, JRadioButton peli) {
        pelinValinta.add(peli);
        getFrame().getContentPane().add(peli);
    }

    private void lisaaJButton(JButton nappi, String teksti, boolean paalla, int tyhjaaLeveys, int tyhjaaKorkeus) {
        nappi.setToolTipText(teksti);
        nappi.setEnabled(paalla);
        getFrame().getContentPane().add(nappi);
        getFrame().getContentPane().add(Box.createRigidArea(new Dimension(tyhjaaLeveys, tyhjaaKorkeus)));
    }
}
