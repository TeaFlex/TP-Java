package be.isims.ihm.dp.tp4.ex2.code;

public class CompteCourant extends Compte {

    public CompteCourant(String denom) {
        super(denom);
    }

    public CompteCourant(double solde, String denom) {
        super(solde, denom);
    }

    @Override
    public void retrait(double somme) {
        this.solde -= somme+(somme*0.05);
    }

    @Override
    public String toString() {
        return "<Compte Courant "+this.denomination+">: solde = "+this.solde+" Euros.";
    }
}
