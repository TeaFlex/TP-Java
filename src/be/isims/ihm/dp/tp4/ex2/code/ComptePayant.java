package be.isims.ihm.dp.tp4.ex2.code;

public class ComptePayant extends Compte {
    public ComptePayant(String denom){
        super(denom);
    }

    public ComptePayant(double solde, String denom) {
        super(solde, denom);
    }

    @Override
    public void retrait(double somme) {
        this.solde -= somme+(somme*0.05);
    }

    @Override
    public void depot(double somme) {
        this.solde += somme-(somme*0.05);
    }

    @Override
    public String toString() {
        return "<Compte Payant "+this.denomination+">: solde = "+this.solde+" Euros.";
    }

}
