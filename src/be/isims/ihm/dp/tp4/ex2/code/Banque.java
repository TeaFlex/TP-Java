package be.isims.ihm.dp.tp4.ex2.code;

import java.util.ArrayList;

public class Banque {
    private ArrayList<Compte> lesComptes = new ArrayList<Compte>();

    public void addCompte(Compte xy) {
        this.lesComptes.add(xy);
    }

    public Compte getCompte(int index) {
        return this.lesComptes.get(index);
    }

    public ArrayList<Compte> collectionComptes() {
        return this.lesComptes;
    }
}
