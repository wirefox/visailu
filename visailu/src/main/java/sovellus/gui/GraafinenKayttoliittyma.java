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

public class GraafinenKayttoliittyma implements Runnable {

    private Peli peli;
    private Kysymys kysymys;
    private JFrame frame;
    private JLabel kysymyslause;
    private JLabel kysymyssana;
    private JRadioButton vaihtoehto1;
    private JRadioButton vaihtoehto2;
    private JRadioButton vaihtoehto3;
    private JRadioButton vaihtoehto4;
    private JRadioButton vaihtoehto5;
    private ButtonGroup vaihtoehdot;
    private JLabel tuloksenIlmoitus;
    private JLabel pistetilanneTeksti;
    private JButton seuraavaKysymys;
    private JLabel lopetuslause;

    public GraafinenKayttoliittyma(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("       Visailu");
        frame.setPreferredSize(new Dimension(600, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentitAloitusikkunaan(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentitAloitusikkunaan(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(Box.createRigidArea(new Dimension(60, 60)));

        JLabel teksti = new JLabel("Tervetuloa visailuun!");
        container.add(teksti);

        container.add(Box.createRigidArea(new Dimension(60, 30)));

        JButton nappi = new JButton("Aloita peli");
        nappi.setToolTipText("aloita peli");
        nappi.addActionListener(new Tapahtumankuuntelija(this, nappi));
        container.add(nappi);
    }

    private void luoKomponentitPeliIkkunaan(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(Box.createRigidArea(new Dimension(60, 20)));

        this.kysymyslause = new JLabel();
        this.kysymyssana = new JLabel();
        container.add(kysymyslause);
        container.add(kysymyssana);

        container.add(Box.createRigidArea(new Dimension(60, 20)));

        this.vaihtoehto1 = new JRadioButton();
        this.vaihtoehto2 = new JRadioButton();
        this.vaihtoehto3 = new JRadioButton();
        this.vaihtoehto4 = new JRadioButton();
        this.vaihtoehto5 = new JRadioButton();

        this.vaihtoehdot = new ButtonGroup();
        this.vaihtoehdot.add(vaihtoehto1);
        this.vaihtoehdot.add(vaihtoehto2);
        this.vaihtoehdot.add(vaihtoehto3);
        this.vaihtoehdot.add(vaihtoehto4);
        this.vaihtoehdot.add(vaihtoehto5);

        container.add(vaihtoehto1);
        container.add(vaihtoehto2);
        container.add(vaihtoehto3);
        container.add(vaihtoehto4);
        container.add(vaihtoehto5);
        
        container.add(Box.createRigidArea(new Dimension(60, 20)));

        this.tuloksenIlmoitus = new JLabel();

        this.pistetilanneTeksti = new JLabel();

        this.seuraavaKysymys = new JButton("Seuraava kysymys");
        this.seuraavaKysymys.setToolTipText("seuraava kysymys");
        this.seuraavaKysymys.setEnabled(false);

        this.lopetuslause = new JLabel();
        this.lopetuslause.setText("");

        container.add(this.tuloksenIlmoitus);
        container.add(Box.createRigidArea(new Dimension(60, 20)));
        container.add(this.pistetilanneTeksti);
        container.add(Box.createRigidArea(new Dimension(60, 20)));
        container.add(this.seuraavaKysymys);
        container.add(Box.createRigidArea(new Dimension(60, 20)));
        container.add(this.lopetuslause);

        this.peli.vaihdaSeuraavaKysymys();
        this.kysymys = this.peli.getKysymys();

        Tapahtumankuuntelija tapahtumanKuuntelija = new Tapahtumankuuntelija(this.peli, this.kysymys, this.vaihtoehdot, this.vaihtoehto1, this.vaihtoehto2, this.vaihtoehto3, this.vaihtoehto4, this.vaihtoehto5, this.seuraavaKysymys, this.kysymyslause, this.kysymyssana, this.tuloksenIlmoitus, this.pistetilanneTeksti, this.lopetuslause);
        this.vaihtoehto1.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto2.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto3.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto4.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto5.addActionListener(tapahtumanKuuntelija);
        this.seuraavaKysymys.addActionListener(tapahtumanKuuntelija);

        this.kysymyslause.setText(this.peli.getKierroksenKysymyslause());
        this.kysymyssana.setText(this.peli.getKysymys().getKysymyssana());

        ArrayList<String> vastausvaihtoehdot = new ArrayList<String>();

        vastausvaihtoehdot.addAll(this.peli.muodostaVastausvaihtoehdot());

        this.vaihtoehto1.setText(vastausvaihtoehdot.get(0));
        this.vaihtoehto2.setText(vastausvaihtoehdot.get(1));
        this.vaihtoehto3.setText(vastausvaihtoehdot.get(2));
        this.vaihtoehto4.setText(vastausvaihtoehdot.get(3));
        this.vaihtoehto5.setText(vastausvaihtoehdot.get(4));

    }

    void tyhjennaIkkuna() {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }

    void teeIkkunaanUusiSisalto() {
        luoKomponentitPeliIkkunaan(frame.getContentPane());
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
