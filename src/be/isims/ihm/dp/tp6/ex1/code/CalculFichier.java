package be.isims.ihm.dp.tp6.ex1.code;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculFichier {

    private Scanner lecteur;
    private String[] nomFichiers = {"operande1.dat", "operande2.dat", "operateurs.dat"};
    private ArrayList<ArrayList> donnees = new ArrayList<>();

    public void lireFichier(){
        try {
            for(String nomFichier : nomFichiers) {
                donnees.add(new ArrayList<String>());
                lecteur = new Scanner(new File(nomFichier));
                while (lecteur.hasNextLine()) {
                    donnees.get(donnees.size()-1).add(lecteur.nextLine());
                }
            }
            this.calcul();
        }
        catch (FileNotFoundException e){
            System.out.println("Erreur: "+e.getMessage());
        }
    }

    private void calcul() {
        double resultat;
        ArrayList<Object> base = donnees.get(0);
        for(ArrayList<Object> f : donnees) base = f.size()<base.size() ? f : base;

        for(int i=0; i<base.size(); i++) {
            switch (donnees.get(2).get(i).toString()){
                case "*":
                    resultat = Double.parseDouble(donnees.get(0).get(i).toString())*
                            Double.parseDouble(donnees.get(1).get(i).toString());
                    break;
                case "-":
                    resultat = Double.parseDouble(donnees.get(0).get(i).toString())-
                            Double.parseDouble(donnees.get(1).get(i).toString());
                    break;
                case "/":
                    resultat = Double.parseDouble(donnees.get(0).get(i).toString())/
                            Double.parseDouble(donnees.get(1).get(i).toString());
                    break;
                case "+":
                default:
                    resultat = Double.parseDouble(donnees.get(0).get(i).toString())+
                            Double.parseDouble(donnees.get(1).get(i).toString());
                    break;
            }
            System.out.println(donnees.get(0).get(i)+
                    " "+donnees.get(2).get(i)+
                    " "+donnees.get(1).get(i)+
                    " = "+resultat);
        }
    }

}
