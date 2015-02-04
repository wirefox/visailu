package sovellus.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import sovellus.logiikka.Visailukoordinaattori;

/**
 * Luokka on visailun graafinen käyttöliittymä, josta kehitetään sovelluksen
 * ainoa käyttöliittymä
 */
public class GraafinenKayttoliittyma implements Runnable {

    private Visailukoordinaattori visailukoordinaattori;
    private JFrame frame;

    public GraafinenKayttoliittyma(Visailukoordinaattori visailukoordinaattori) {
        this.visailukoordinaattori = visailukoordinaattori;
    }

    @Override
    public void run() {
        frame = new JFrame("Visailu");
        frame.setPreferredSize(new Dimension(300, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

//    private void luoKomponentitAloitusnakymaan(Container container) {
//        JLabel teksti = new JLabel("Moikka! Tervetuloa visailuun!");
//        container.add(teksti);
//
//        JButton nappi = new JButton("Aloita peli");
//        nappi.addActionListener(new Tapahtumankuuntelija());
//        container.add(nappi);
//
//        //kun nappia painetaan, päivittyy ikkuna pelinäkymän mukaiseksi (luoKomponentitPeliin),
//        // miten tämä tapahtuu?? run-metodissa, tapahtumankuuntelijan kautta??
//        SwingUtilities.updateComponentTreeUI(frame);
//        frame.invalidate();
//        frame.validate();
//        frame.repaint();
//    }
    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Tähän tulisi kysymyslause"));
        container.add(new JLabel("Ja tähän kysymyssana"));
        container.add(new JLabel("valitse allaolevista vaihtoehdoista"));
        container.add(new JLabel(" "));

        JRadioButton vaihtoehto1 = new JRadioButton("Vaihtoehto 1");
        JRadioButton vaihtoehto2 = new JRadioButton("Vaihtoehto 2");
        JRadioButton vaihtoehto3 = new JRadioButton("Vaihtoehto 3");
        JRadioButton vaihtoehto4 = new JRadioButton("Vaihtoehto 4");
        JRadioButton vaihtoehto5 = new JRadioButton("Vaihtoehto 5");

        Tapahtumankuuntelija tapahtumanKuuntelija = new Tapahtumankuuntelija(this.visailukoordinaattori, vaihtoehto1, vaihtoehto2, vaihtoehto3, vaihtoehto4, vaihtoehto5);
        vaihtoehto1.addActionListener(tapahtumanKuuntelija);
        vaihtoehto2.addActionListener(tapahtumanKuuntelija);
        vaihtoehto3.addActionListener(tapahtumanKuuntelija);
        vaihtoehto4.addActionListener(tapahtumanKuuntelija);
        vaihtoehto5.addActionListener(tapahtumanKuuntelija);

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

        JTextArea tuloksenIlmoitus = new JTextArea("Tähän tulee teksti, onko vastaus oikein vai väärin");
        JTextArea pistetilanneTeksti = new JTextArea("Tähän tulee pistetilanne, Pisteesi xx/xx");
        container.add(tuloksenIlmoitus);
        container.add(pistetilanneTeksti);
    }

    public JFrame getFrame() {
        return frame;
    }
}
