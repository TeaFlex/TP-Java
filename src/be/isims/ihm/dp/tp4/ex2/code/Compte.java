package be.isims.ihm.dp.tp4.ex2.code;

public abstract class Compte {

    protected double solde = 0;
    protected String denomination;

    public Compte(String denomination) {
        this.denomination = denomination;
    }

    public Compte(double solde, String denomination) {
        this.solde = solde<0 ? 0 : solde;
        this.denomination = denomination;
    }

    public void depot(double somme){
        this.solde += somme<0 ? 0 : somme;
    }

    public void retrait(double somme) {
        this.solde -= somme<0 ? 0 : somme;
    }

    public String getDenomination() {
        return denomination;
    }
}
