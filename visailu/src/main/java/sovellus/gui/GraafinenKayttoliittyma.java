package sovellus.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
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

/**
 * Luokka on visailun graafinen käyttöliittymä, josta kehitetään sovelluksen
 * ainoa käyttöliittymä - vielä hyvin keskeneräinen
 *
 * @author elina
 */
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
    private JTextArea tuloksenIlmoitus;
    private JTextArea pistetilanneTeksti;
    private JButton seuraavaKysymys;
    private JTextArea lopetuslause;

    public GraafinenKayttoliittyma(Peli peli) {
        this.peli = peli;
        run();
    }

    @Override
    public void run() {
        frame = new JFrame("Visailu");
        frame.setPreferredSize(new Dimension(500, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentitAloitusikkunaan(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentitAloitusikkunaan(Container container) {
        JLabel teksti = new JLabel();
        container.add(teksti);
        teksti.setText("Moikka! Tervetuloa visailuun!");

        JButton nappi = new JButton("Aloita peli");
        nappi.addActionListener(new Tapahtumankuuntelija(this, nappi));
        container.add(nappi);
    }

    private void luoKomponentitPeliIkkunaan(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        this.kysymyslause = new JLabel();
        this.kysymyssana = new JLabel();
        container.add(kysymyslause);
        container.add(kysymyssana);

        this.vaihtoehto1 = new JRadioButton();
        this.vaihtoehto2 = new JRadioButton();
        this.vaihtoehto3 = new JRadioButton();
        this.vaihtoehto4 = new JRadioButton();
        this.vaihtoehto5 = new JRadioButton();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(vaihtoehto1);
        buttonGroup.add(vaihtoehto2);
        buttonGroup.add(vaihtoehto3);
        buttonGroup.add(vaihtoehto4);
        buttonGroup.add(vaihtoehto5);

        container.add(vaihtoehto1);
        container.add(vaihtoehto2);
        container.add(vaihtoehto3);
        container.add(vaihtoehto4);
        container.add(vaihtoehto5);

        this.tuloksenIlmoitus = new JTextArea();
        this.pistetilanneTeksti = new JTextArea();
        this.seuraavaKysymys = new JButton("Seuraava kysymys");
        this.lopetuslause = new JTextArea();

        container.add(this.tuloksenIlmoitus);
        container.add(this.pistetilanneTeksti);
        container.add(this.seuraavaKysymys);
        container.add(this.lopetuslause);

        this.peli.vaihdaSeuraavaKysymys();
        this.kysymys = this.peli.getKysymys();

        Tapahtumankuuntelija tapahtumanKuuntelija = new Tapahtumankuuntelija(this.peli, this.kysymys, this.vaihtoehto1, this.vaihtoehto2, this.vaihtoehto3, this.vaihtoehto4, this.vaihtoehto5, this.seuraavaKysymys, this.kysymyslause, this.kysymyssana, this.tuloksenIlmoitus, this.pistetilanneTeksti, this.lopetuslause);
        this.vaihtoehto1.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto2.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto3.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto4.addActionListener(tapahtumanKuuntelija);
        this.vaihtoehto5.addActionListener(tapahtumanKuuntelija);
        this.seuraavaKysymys.addActionListener(tapahtumanKuuntelija);

        this.kysymyslause.setText(this.peli.getKierroksenKysymyslause());
        this.kysymyssana.setText(this.peli.getKysymys().getKysymyssana());

        ArrayList<String> vastausvaihtoehdot = new ArrayList<String>();

        vastausvaihtoehdot.addAll(this.peli.getVastausvaihtoehdot());

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
