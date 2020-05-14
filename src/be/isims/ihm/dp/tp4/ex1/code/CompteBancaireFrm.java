package be.isims.ihm.dp.tp4.ex1.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompteBancaireFrm extends JFrame {

    private JTextField champ = new JTextField(10);
    private JLabel total = new JLabel();
    private JTextArea historique = new JTextArea(1, 5);

    public CompteBancaireFrm() {
        this.setTitle("TP4 ex1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(450,100));
        this.setLayout(new FlowLayout());

        AjouteMontantEcouteur ecouteur = new AjouteMontantEcouteur(this);
        this.total.setText("Votre solde: "+ecouteur.getSolde()+" €");
        this.historique.append(ecouteur.getSolde()+" €");
        JButton bouton = new JButton("Ajouter montant");
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecouteur.update();
            }
        });
        this.getContentPane().add(new JLabel("Montant"));
        this.getContentPane().add(champ);
        this.getContentPane().add(bouton);
        this.getContentPane().add(total);
        JScrollPane scroll = new JScrollPane(this.historique,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.getContentPane().add(scroll);
        this.setVisible(true);
    }

    public String getValue() {
        return this.champ.getText();
    }

    public void setTotal(double valeur) {
        this.total.setText("Votre solde: "+valeur+" €");
        this.historique.append("\n"+valeur+" €");
    }

    public class AjouteMontantEcouteur {
        private CompteBancaire compte = new CompteBancaire(0);
        private CompteBancaireFrm fenetre;

        public AjouteMontantEcouteur(CompteBancaireFrm fenetre) {
            this.fenetre = fenetre;
        }

        public void update() {
            boolean inputtest = true;
            try{
                Double.parseDouble(this.fenetre.getValue());
            }
            catch (NumberFormatException e){
                inputtest = false;
            }
            if(!this.fenetre.getValue().equals("") && inputtest) {
                this.compte.depot(Double.parseDouble(this.fenetre.getValue()));
                this.fenetre.setTotal(this.compte.getSolde());
            }
        }

        public Double getSolde(){
            return this.compte.getSolde();
        }
    }
}
