package be.isims.ihm.dp.tp4.ex2.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BanqueFrm extends JFrame {

    private Banque banque;
    private JTextField valeur = new JTextField(10);
    private JComboBox<Compte> liste;
    private JRadioButton radioButtons[] = {new JRadioButton("Dépôt"), new JRadioButton("Retrait")};
    private JTextArea historique = new JTextArea();

    public BanqueFrm(Banque banque) {
        this.banque = banque;
        //instanciations des attributs
        this.liste = new JComboBox<Compte>(this.banque.collectionComptes().toArray(new Compte[0]));

        //paamétrage de la fenêtre
        this.setTitle("TP4 ex2");
        this.setMinimumSize(new Dimension(400, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //création du contenu de la fenêtre par ligne
        ArrayList<JPanel> lignes = new ArrayList<JPanel>();
        JPanel bg = new JPanel();
        bg.setLayout(new BoxLayout(bg, BoxLayout.PAGE_AXIS));
        for(int i=0; i<5; i++) {
            lignes.add(new JPanel());
            lignes.get(i).setLayout(new BoxLayout(lignes.get(i), BoxLayout.LINE_AXIS));
            lignes.get(i).setAlignmentX(Component.LEFT_ALIGNMENT);
            bg.add(new Box.Filler(new Dimension(10, 10),
                                new Dimension(10, 10),
                                new Dimension(15, 15)));
            bg.add(lignes.get(i));
        }

        //ligne 0
        lignes.get(0).add(new JLabel("Montant"));
        lignes.get(0).add(Box.createRigidArea(new Dimension(10, 10)));
        valeur.setMaximumSize(valeur.getPreferredSize());
        lignes.get(0).add(valeur);

        //ligne 1
        lignes.get(1).add(new JLabel("Compte"));
        lignes.get(1).add(Box.createRigidArea(new Dimension(10, 10)));
        liste.setMaximumSize(liste.getPreferredSize());
        lignes.get(1).add(this.liste);

        //ligne 2
        lignes.get(2).add(new JLabel("Transaction"));
        lignes.get(2).add(Box.createRigidArea(new Dimension(10, 10)));

        ButtonGroup radioGroupe = new ButtonGroup();
        radioGroupe.add(radioButtons[0]);
        radioGroupe.add(radioButtons[1]);
        lignes.get(2).add(radioButtons[0]);
        lignes.get(2).add(radioButtons[1]);

        //ligne 3
        Observeur observeur = new Observeur(){
            private BanqueFrm fenetre = null;

            @Override
            public void setFenetre(BanqueFrm f) {
                this.fenetre = f;
            }

            @Override
            public void update(){
                try{
                    if(Double.parseDouble(fenetre.getValeur())>=0) {
                        if(fenetre.getOperation() == "Dépôt") {
                            fenetre.getCompteSelectionne().depot(Double.parseDouble(fenetre.getValeur()));
                        }
                        else if (fenetre.getOperation() == "Retrait") {
                            fenetre.getCompteSelectionne().retrait(Double.parseDouble(fenetre.getValeur()));
                        }
                        fenetre.addToHistorique(fenetre.getCompteSelectionne().toString());
                    }
                    else fenetre.addToHistorique("Le montant ne peut être négatif.");
                }
                catch (Exception e){
                    fenetre.addToHistorique("Erreur: "+e.getMessage());
                }
            }

            @Override
            public void getInfos() {
                if(fenetre.getCompteSelectionne().getClass() == CompteEpargne.class)
                    fenetre.addToHistorique(((CompteEpargne) fenetre.getCompteSelectionne()).getInterets());
                else
                    fenetre.addToHistorique("Opération impossible.");
            }
        };
        observeur.setFenetre(this);
        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                observeur.update();
            }
        });
        JButton calcul = new JButton("Calculer Intérêts");
        calcul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                observeur.getInfos();
            }
        });
        lignes.get(3).add(valider);
        lignes.get(3).add(Box.createRigidArea(new Dimension(20, 0)));
        lignes.get(3).add(calcul);

        //ligne 4
        JScrollPane scroll = new JScrollPane(this.historique,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        lignes.get(4).add(scroll);

        //ajout du contenu à la fenêtre et lancement
        this.getContentPane().add(bg);
        this.setVisible(true);
    }

    public String getValeur() {
        return this.valeur.getText();
    }

    public void addToHistorique(String action) {
        this.historique.append(action+"\n");
    }

    public Compte getCompteSelectionne() {
        return this.liste.getItemAt(this.liste.getSelectedIndex());
    }

    public String getOperation() {
        for (JRadioButton b : this.radioButtons) {
            if(b.isSelected()) return b.getText();
        }
        return "";
    }
}
