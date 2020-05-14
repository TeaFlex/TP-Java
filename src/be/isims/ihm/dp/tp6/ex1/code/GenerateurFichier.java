package be.isims.ihm.dp.tp6.ex1.code;
import javax.swing.*;
import java.io.*;

public class GenerateurFichier {

    private File fichier = new File("default.txt");
    private FileWriter ecrire;

    public void stockerNombre(String nomFichier, int[] tableau) {
        this.creerFichier(nomFichier);
        try{
            this.ecrire = new FileWriter(this.fichier.getName());
            for (int entier : tableau) {
                ecrire.write(String.valueOf(entier)+"\n");
            }
            ecrire.close();
            System.out.println("Ecriture réalisée dans "+this.fichier.getName());
        }
        catch (IOException e){
            this.erreur(e.getMessage());
        }
    }

    public void stockerCaracteres(String nomFichier, char[] tableau) {
        this.creerFichier(nomFichier);
        try{
            this.ecrire = new FileWriter(this.fichier.getName());
            for (char lettre : tableau) {
                ecrire.write(String.valueOf(lettre)+"\n");
            }
            ecrire.close();
            System.out.println("Ecriture réalisée dans "+this.fichier.getName());
        }
        catch (IOException e){
            this.erreur(e.getMessage());
        }
    }

    private void creerFichier(String nomFichier){
        try{
            this.fichier = new File(nomFichier);
            if(this.fichier.createNewFile()){
                System.out.println("Fichier créé: "+ fichier.getName());
            }
            else {
                System.out.println("Le fichier "+fichier.getName()+" existe déjà.");
            }
        }
        catch (IOException e){
            this.erreur(e.getMessage());
        }
    }

    private void erreur(String message){
        System.out.println("Une erreur s'est produite.");
        System.out.println(message);
    }
}
