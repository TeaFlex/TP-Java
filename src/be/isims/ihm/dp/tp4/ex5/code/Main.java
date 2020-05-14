package be.isims.ihm.dp.tp4.ex5.code;

public class Main {
    public static void main(String[] args) {
        AbstractObservable ob = new ColorModel();
        AbstractController oc = new Controller(ob);
        Observer ov = new ViewFrm(oc);
        ob.setObserver(ov);
    }
}
