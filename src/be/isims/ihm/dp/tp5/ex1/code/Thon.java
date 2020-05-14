package be.isims.ihm.dp.tp5.ex1.code;

import be.isims.ihm.dp.tp5.ex1.code.Pizza;
import be.isims.ihm.dp.tp5.ex1.code.PizzaDecorator;

public class Thon extends PizzaDecorator {

    public Thon(Pizza base) {
        super(base);
        this.prix = 1.5;
    }
}
