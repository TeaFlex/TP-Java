package be.isims.ihm.dp.tp4.ex6.code;

public class TemperatureModel extends AbstractModel {

    @Override
    public void getTemperature(int temp, String operation) {
        switch (operation){
            case "+":
                temp++;
                break;
            case "-":
                temp--;
                break;
            case "Valider":
                break;
        }
        this.observer.update(String.valueOf(temp), operation);
    }
}
