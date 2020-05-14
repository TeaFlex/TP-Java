package be.isims.ihm.dp.tp4.ex5.code;

//MODELE
public abstract class AbstractObservable {
    protected Observer observer;

    public void setObserver(Observer observer) {
        this.observer = observer;
    }
    public abstract void toHex(int r, int g, int b);
}
