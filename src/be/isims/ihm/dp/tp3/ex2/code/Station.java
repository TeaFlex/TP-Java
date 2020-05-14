package be.isims.ihm.dp.tp3.ex2.code;

import java.util.ArrayList;

public abstract class Station {
    protected ArrayList<Affichage> affichages = new ArrayList<Affichage>();

    public void addObservateur(Affichage affIN){
        affichages.add(affIN);
    }

    public  void delObservateur(Affichage affIN){
        affichages.remove(affIN);
    }

    public void notifier(){
        for (Affichage affichage : affichages) {
            affichage.update();
        }
    }
}
