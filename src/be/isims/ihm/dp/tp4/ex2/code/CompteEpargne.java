package be.isims.ihm.dp.tp4.ex2.code;

public class CompteEpargne extends Compte {

    private double taux = 0.05;

    public CompteEpargne(String denom) {
        super(denom);
    }

    public CompteEpargne(String denom, double solde) {
        super(solde, denom);
    }

    public Double getTaux() {
        return this.taux;
    }

    public void calculInterets() {
        this.solde += this.solde*this.taux;
    }

    public String getInterets() {
        return "Votre intérêt: "+this.solde*this.taux+" Euros.";
    }

    @Override
    public String toString() {
        return "<Compte Epargne "+this.denomination+">: solde = "+this.solde+" Euros.";
    }
}
