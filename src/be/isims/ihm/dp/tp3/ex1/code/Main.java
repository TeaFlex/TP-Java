package be.isims.ihm.dp.tp3.ex1.code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Saisi saisi=new Saisi();
        ConvBin convB=new ConvBin(saisi);
        ConvHex convH=new ConvHex(saisi);
        ConvOct convO=new ConvOct(saisi);
        saisi.ajouter(convO);
        saisi.ajouter(convB);
        saisi.ajouter(convH);
        Scanner sc=new Scanner(System.in);
        while(true){
            try{
                System.out.println("Saisir un entier :");
                saisi.setNombre(sc.nextInt());
            }
            catch (Exception e){
                System.out.println("Une erreur s'est produite.");
                break;
            }
        }
    }
}
