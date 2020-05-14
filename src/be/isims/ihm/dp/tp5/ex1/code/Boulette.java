package be.isims.ihm.dp.tp5.ex1.code;

import be.isims.ihm.dp.tp5.ex1.code.Pizza;
import be.isims.ihm.dp.tp5.ex1.code.PizzaDecorator;

public class Boulette extends PizzaDecorator {

    public Boulette(Pizza base) {
        super(base);
        this.prix = 2;
    }
}
