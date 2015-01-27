package sovellus.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Visailu");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentitAloitusnakymaan(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentitAloitusnakymaan(Container container) {
        JLabel teksti = new JLabel("Moikka! Tervetuloa visailuun!");
        container.add(teksti);

        JButton nappi = new JButton("Aloita peli");
        nappi.addActionListener(new Tapahtumankuuntelija());
        container.add(nappi);

        //kun nappia painetaan, päivittyy ikkuna pelinäkymän mukaiseksi (luoKomponentitPeliin),
        // miten tämä tapahtuu?? run-metodissa, tapahtumankuuntelijan kautta??
        //?  SwingUtilities.updateComponentTreeUI(frame);
        //? frame.invalidate();
        //? frame.validate();
        //? frame.repaint();
    }

    private void luoKomponentitPeliin(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Tähän tulisi kysymyslause"));

        JRadioButton vaihtoehto1 = new JRadioButton("Vaihtoehto 1");
        JRadioButton vaihtoehto2 = new JRadioButton("Vaihtoehto 2");
        JRadioButton vaihtoehto3 = new JRadioButton("Vaihtoehto 3");
        JRadioButton vaihtoehto4 = new JRadioButton("Vaihtoehto 4");
        JRadioButton vaihtoehto5 = new JRadioButton("Vaihtoehto 5");

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
    }

    public JFrame getFrame() {
        return frame;
    }
}