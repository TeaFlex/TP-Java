package be.isims.ihm.dp.tp4.ex4.code;

public interface Observable {
    public void addObserver(Observer ob);
    public void removeObserver();
    public void notifyObserver(String value, String target, String rate);
}
