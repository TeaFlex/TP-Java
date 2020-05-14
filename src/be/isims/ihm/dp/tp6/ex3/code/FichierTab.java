package be.isims.ihm.dp.tp6.ex3.code;

import java.io.RandomAccessFile;
import java.nio.*;

public class FichierTab {
    private int taille;
    private String fichier;

    public FichierTab(int taille, String fichier){
        this.taille = taille;
        this.fichier = fichier;
    }

    public void ecrire(int index, int valeur) {
        try {
            if(!(index>=0 && index<taille)){
                IntBuffer buffer = IntBuffer.allocate(this.taille);
                RandomAccessFile raf = new RandomAccessFile("tab.txt", "rw");
                buffer.put(index, valeur);

            }
            else throw new ArrayIndexOutOfBoundsException();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int lire(int index) {
        try {
            if(!(index>=0 && index<taille)){
                return 0;
            }
            else throw new ArrayIndexOutOfBoundsException();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
