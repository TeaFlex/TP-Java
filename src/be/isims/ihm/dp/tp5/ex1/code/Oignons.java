package be.isims.ihm.dp.tp5.ex1.code;

import be.isims.ihm.dp.tp5.ex1.code.Pizza;
import be.isims.ihm.dp.tp5.ex1.code.PizzaDecorator;

public class Oignons extends PizzaDecorator {

    public Oignons(Pizza base) {
        super(base);
        this.prix = 0.5;
    }
}
