package be.isims.ihm.dp.tp5.ex1.code;

import be.isims.ihm.dp.tp5.ex1.code.Pizza;
import be.isims.ihm.dp.tp5.ex1.code.PizzaDecorator;

public class Fromage extends PizzaDecorator {

    public Fromage(Pizza base) {
        super(base);
        this.prix = 0.7;
    }
}
