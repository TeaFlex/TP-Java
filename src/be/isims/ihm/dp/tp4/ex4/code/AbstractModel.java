package be.isims.ihm.dp.tp4.ex4.code;

import be.isims.ihm.dp.tp4.ex4.code.Observable;
import be.isims.ihm.dp.tp4.ex4.code.Observer;

import java.util.ArrayList;

public abstract class AbstractModel implements Observable {

    private ArrayList<Observer> obs = new ArrayList<Observer>();

    public abstract void convertcurrency(String value, String target, String rate);
    public abstract void converttaxes(String value, String target, String rate);

    public void addObserver(Observer ob) {
        this.obs.add(ob);
    }

    public void removeObserver(){
        this.obs = new ArrayList<Observer>();
    }

    public void notifyObserver(String value, String target, String rate) {
        for(Observer ob : obs) {
            ob.update(value, target, rate);
        }
    }
}
