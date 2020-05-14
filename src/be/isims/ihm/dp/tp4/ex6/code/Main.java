package be.isims.ihm.dp.tp4.ex6.code;

public class Main {
    public static void main(String[] args) {
        TemperatureModel temp = new TemperatureModel();
        ConcreteController ctrl = new ConcreteController(temp);
        ViewFrm frm = new ViewFrm(ctrl);
        temp.setObserver(frm);
    }
}
