package be.isims.ihm.dp.tp4.ex6.code;

public abstract class AbstractModel {

    protected Observer observer;

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public abstract void getTemperature(int temp, String operation);
}
