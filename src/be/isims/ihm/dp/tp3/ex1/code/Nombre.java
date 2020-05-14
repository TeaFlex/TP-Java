package be.isims.ihm.dp.tp3.ex1.code;

import java.util.ArrayList;

public abstract class Nombre {

    protected ArrayList<Conversion> conversions = new ArrayList<Conversion>();

    public void ajouter(Conversion conversion){
        if(!conversions.contains(conversion))
            conversions.add(conversion);
    }

    public void supprimer(Conversion conversion){
        if(conversions.contains(conversion))
            conversions.remove(conversion);
    }

    public void notifie(){
        for (Conversion conversion : conversions) {
            conversion.actualise();
        }
    }

    public abstract void setNombre(int nombre);
    public abstract int getNombre();
}
