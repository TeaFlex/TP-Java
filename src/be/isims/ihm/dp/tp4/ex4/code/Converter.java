package be.isims.ihm.dp.tp4.ex4.code;

import be.isims.ihm.dp.tp4.ex4.code.AbstractModel;

public class Converter extends AbstractModel {

    private double result = 0;
    private double rate = 0;

    public void convertcurrency(String value, String target, String rate) {
        this.rate = Double.parseDouble(rate);
        this.result = Double.parseDouble(value)*this.rate;
        this.notifyObserver(String.valueOf(this.result), target, rate);
    }

    public void converttaxes(String value, String target, String rate){
        this.rate = Double.parseDouble(rate)/100;
        this.result = target.equals("TTC") ? Double.parseDouble(value)+(Double.parseDouble(value)*this.rate):
                Double.parseDouble(value)-(Double.parseDouble(value)*this.rate);
        this.notifyObserver(String.valueOf(this.result), target, rate);
    }
}
