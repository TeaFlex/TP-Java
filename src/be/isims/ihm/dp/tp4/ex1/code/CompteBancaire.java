package be.isims.ihm.dp.tp4.ex1.code;

public class CompteBancaire {
    private double solde;

    public CompteBancaire(double solde) {
        this.solde = solde<0 ? 0 : solde;
    }

    public void depot(double value) {
        this.solde+=value;
    }

    public double getSolde() {
        return this.solde;
    }
}
