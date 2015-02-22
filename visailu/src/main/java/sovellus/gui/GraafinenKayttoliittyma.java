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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import sovellus.domain.Kysymys;
import sovellus.logiikka.Peli;
import sovellus.logiikka.Visailukoordinaattori;

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
     * jossa pelaaja valitsee pelin
     *
     * @param container-olio
     */
    private void luoKomponentitAloitusikkunaan(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(Box.createRigidArea(new Dimension(60, 60)));

        JLabel tervetuloaTeksti = new JLabel("Tervetuloa oppimaan!");
        container.add(tervetuloaTeksti);

        container.add(Box.createRigidArea(new Dimension(60, 10)));

        JLabel valintaTeksti = new JLabel("Valitse peli, jota haluat pelata:");
        container.add(valintaTeksti);

        container.add(Box.createRigidArea(new Dimension(60, 10)));

        JRadioButton paakaupunkiPeli = new JRadioButton("valtiot ja pääkaupungit");
        JRadioButton kiinaNumeroPeli = new JRadioButton("kiinan numerot");
        ButtonGroup pelinValinta = new ButtonGroup();
        pelinValinta.add(paakaupunkiPeli);
        pelinValinta.add(kiinaNumeroPeli);
        container.add(paakaupunkiPeli);
        container.add(kiinaNumeroPeli);

        container.add(Box.createRigidArea(new Dimension(60, 30)));

        JButton aloitusNappi = new JButton("Aloita peli");
        aloitusNappi.setToolTipText("aloita peli");
        aloitusNappi.setEnabled(false);

        container.add(aloitusNappi);

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
        JLabel kysymyssana = new JLabel();
        container.add(kysymyslause);
        container.add(kysymyssana);

        container.add(Box.createRigidArea(new Dimension(60, 20)));

        JRadioButton vaihtoehto1 = new JRadioButton();
        JRadioButton vaihtoehto2 = new JRadioButton();
        JRadioButton vaihtoehto3 = new JRadioButton();
        JRadioButton vaihtoehto4 = new JRadioButton();
        JRadioButton vaihtoehto5 = new JRadioButton();

        ButtonGroup vaihtoehdot = new ButtonGroup();
        vaihtoehdot.add(vaihtoehto1);
        vaihtoehdot.add(vaihtoehto2);
        vaihtoehdot.add(vaihtoehto3);
        vaihtoehdot.add(vaihtoehto4);
        vaihtoehdot.add(vaihtoehto5);

        container.add(vaihtoehto1);
        container.add(vaihtoehto2);
        container.add(vaihtoehto3);
        container.add(vaihtoehto4);
        container.add(vaihtoehto5);

        container.add(Box.createRigidArea(new Dimension(60, 20)));

        JLabel tuloksenIlmoitus = new JLabel();

        JLabel pistetilanneTeksti = new JLabel();

        JButton seuraavaKysymys = new JButton("Seuraava kysymys");
        seuraavaKysymys.setToolTipText("seuraava kysymys");
        seuraavaKysymys.setEnabled(false);

        JLabel lopetuslause = new JLabel();
        lopetuslause.setText("");

        container.add(tuloksenIlmoitus);
        container.add(Box.createRigidArea(new Dimension(60, 20)));
        container.add(pistetilanneTeksti);
        container.add(Box.createRigidArea(new Dimension(60, 20)));
        container.add(seuraavaKysymys);
        container.add(Box.createRigidArea(new Dimension(60, 20)));
        container.add(lopetuslause);
        container.add(Box.createRigidArea(new Dimension(60, 20)));

        this.peli.vaihdaSeuraavaKysymys();

        Tapahtumankuuntelija tapahtumanKuuntelija = new Tapahtumankuuntelija(this.peli, vaihtoehdot, vaihtoehto1, vaihtoehto2, vaihtoehto3, vaihtoehto4, vaihtoehto5, seuraavaKysymys, kysymyslause, kysymyssana, tuloksenIlmoitus, pistetilanneTeksti, lopetuslause);
        vaihtoehto1.addActionListener(tapahtumanKuuntelija);
        vaihtoehto2.addActionListener(tapahtumanKuuntelija);
        vaihtoehto3.addActionListener(tapahtumanKuuntelija);
        vaihtoehto4.addActionListener(tapahtumanKuuntelija);
        vaihtoehto5.addActionListener(tapahtumanKuuntelija);
        seuraavaKysymys.addActionListener(tapahtumanKuuntelija);

        kysymyslause.setText(this.peli.getKierroksenKysymyslause());
        kysymyssana.setText(this.peli.getKysymys().getKysymyssana());

        ArrayList<String> vastausvaihtoehdot = new ArrayList<String>();

        vastausvaihtoehdot.addAll(this.peli.muodostaVastausvaihtoehdot());

        vaihtoehto1.setText(vastausvaihtoehdot.get(0));
        vaihtoehto2.setText(vastausvaihtoehdot.get(1));
        vaihtoehto3.setText(vastausvaihtoehdot.get(2));
        vaihtoehto4.setText(vastausvaihtoehdot.get(3));
        vaihtoehto5.setText(vastausvaihtoehdot.get(4));

        frame.setVisible(true);
    }

    void tyhjennaIkkuna() {
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().repaint();
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
