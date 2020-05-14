package be.isims.ihm.dp.tp2.ex1.code;

public class Facture {
    private float total;
    private final int prix = 90;
    private Affichage affichage;

    public Facture(int nombreproduit){
        calcul(nombreproduit);
        affichage = new AffichageFR();
    }

    public void calcul(int nb){
        //calcule le total de la facture
        total=nb*prix;
    }

    public float getTotal() {
        return total;
    }

    public void setAffichage(Affichage affichage) {
        this.affichage = affichage;
    }

    public void afficher(){
        System.out.println(affichage.afficher()+ total);
    }
}
