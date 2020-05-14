package be.isims.ihm.dp.tp4.ex2.code;

public class Main {
    public static void main(String[] args) {
        Banque b = new Banque();
        b.addCompte(new CompteCourant("Roberto"));
        b.addCompte(new CompteEpargne("Sandra"));
        b.addCompte(new ComptePayant("Emmanuel"));
        BanqueFrm f = new BanqueFrm(b);
    }
}
