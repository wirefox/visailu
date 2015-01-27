package sovellus.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class Tapahtumankuuntelija implements ActionListener {

    private JRadioButton vaihtoehto1;
    private JRadioButton vaihtoehto2;
    private JRadioButton vaihtoehto3;
    private JRadioButton vaihtoehto4;
    private JRadioButton vaihtoehto5;

    Tapahtumankuuntelija(JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JRadioButton vaihtoehto4, JRadioButton vaihtoehto5) {
        this.vaihtoehto1 = vaihtoehto1;
        this.vaihtoehto2 = vaihtoehto2;
        this.vaihtoehto3 = vaihtoehto3;
        this.vaihtoehto4 = vaihtoehto4;
        this.vaihtoehto5 = vaihtoehto5;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vaihtoehto1) {
            System.out.println("vaihtoehto 1 valittu");
        } else if (ae.getSource() == vaihtoehto2) {
            System.out.println("vaihtoehto 2 valittu");
        } else if (ae.getSource() == vaihtoehto3) {
            System.out.println("vaihtoehto 3 valittu");
        } else if (ae.getSource() == vaihtoehto4) {
            System.out.println("vaihtoehto 4 valittu");
        } else if (ae.getSource() == vaihtoehto5) {
            System.out.println("vaihtoehto 5 valittu");
        }
    }
}