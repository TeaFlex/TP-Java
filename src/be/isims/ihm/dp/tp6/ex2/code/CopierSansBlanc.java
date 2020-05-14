package be.isims.ihm.dp.tp6.ex2.code;

import java.io.*;
import java.nio.*;
import java.util.Scanner;

public class CopierSansBlanc {
    CharBuffer charBuffer = CharBuffer.allocate(512);

    public void copier(String source, String destination) {
        try{
            File fichierDes = new File(destination);
            FileWriter scribe = null;

            //création du fichier cible
            if(fichierDes.createNewFile())
                System.out.println("Le fichier "+destination+" a été créé.");
            else
                System.out.println("Le fichier "+destination+" existe déjà.");

            //lecture du fichier source
            FileReader lecteur = new FileReader(new File(source));
            int content;
            while ((content = lecteur.read()) != -1){
                //si le buffer est plein, on écrit dans le fichier source
                if(charBuffer.length() == 0){
                    scribe = new FileWriter(destination);
                    charBuffer.flip();
                    for(int i = 0; charBuffer.hasRemaining(); i++) scribe.write(charBuffer.get());
                    scribe.close();
                }
                //filtrage des caratères
                if((char) content != '\n')
                    charBuffer.put(Character.isWhitespace((char) content) ? '_' : (char) content);
            }
            lecteur.close();
            //on écrit le reste du contenu du buffer dans le fichier cible
            scribe = new FileWriter(destination);
            charBuffer.flip();
            for(int i = 0; charBuffer.hasRemaining(); i++) scribe.write(charBuffer.get());
            scribe.close();
        }
        catch (Exception e){
            System.out.println("Erreur: "+e.getMessage());
        }
    }
}
