package be.isims.ihm.dp.tp4.ex3.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;

public class CalculatriceFrm extends JFrame {

    private Calculatrice calculatrice = new Calculatrice();
    private JTextArea calcul = new JTextArea();
    private JTextArea resultat = new JTextArea();

    public CalculatriceFrm() {
        this.setTitle("TP4 ex3");
        this.setMinimumSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.resultat.setFont(new Font("Arial", Font.PLAIN, 20));
        this.calcul.setFont(resultat.getFont());

        String arr[] = Arrays.stream(IntStream.range(0, 10).toArray()).mapToObj(String::valueOf).toArray(String[]::new);
        JPanel clavier = this.getPanel(Arrays.asList(arr), new JPanel());
        clavier.setLayout(new GridLayout(4, 4, 5, 5));


        JPanel operations = this.getPanel(Arrays.asList(Calculatrice.operations), new JPanel());
        operations.setLayout(new GridLayout(5, 1));

        JPanel egal = this.getPanel(Arrays.asList("="), new JPanel());
        egal.setLayout(new GridLayout(1,1));

        JPanel ecran = new JPanel();
        ecran.setLayout(new GridLayout(2, 1, 5, 5));
        ecran.add(calcul);
        ecran.add(resultat);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(clavier, BorderLayout.CENTER);
        this.getContentPane().add(operations, BorderLayout.EAST);
        this.getContentPane().add(ecran, BorderLayout.NORTH);
        this.getContentPane().add(egal, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public Calculatrice getCalculatrice() {
        return this.calculatrice;
    }

    public JTextArea getResultat() {
        return this.resultat;
    }

    public void setResultat(String valeur) {
        this.resultat.setText(valeur);
    }

    public void ajoutCalcul(String valeur) {
        this.calcul.append(valeur);
    }

    public void setCalcul(String valeur){
        this.calcul.setText("");
    }

    public String getCalcul() {
        return this.calcul.getText();
    }

    private JPanel getPanel(List<String> valeursClavier, JPanel panel) {
        CalculatriceObserveur observeur = new CalculatriceObserveur(this);
        ArrayList<JButton> boutons = new ArrayList<>();
        for(String contenu : valeursClavier) {
            boutons.add(new JButton(contenu));
            boutons.get(boutons.size()-1).setFont(new Font("Arial", Font.PLAIN, 20));
            panel.add(boutons.get(boutons.size()-1));
            boutons.get(boutons.size()-1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    observeur.update(contenu);
                }
            });
        }
        return panel;
    }
}
