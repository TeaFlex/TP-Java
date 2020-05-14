package be.isims.ihm.dp.tp2.ex1.code;

public class Client {
    public static void main(String[] args) {
        Facture maFacture=new Facture(50);
        System.out.println("Par défaut (Belgique)");
        System.out.println("---------------------");
        maFacture.afficher();
        System.out.println("\nAllemagne");
        System.out.println("----------");
        maFacture.setAffichage(new AffichageD());
        maFacture.afficher();
        System.out.println("\nRoyaume-Uni");
        System.out.println("----------");
        maFacture.setAffichage(new AffichageUK());
        maFacture.afficher();

    }
}
