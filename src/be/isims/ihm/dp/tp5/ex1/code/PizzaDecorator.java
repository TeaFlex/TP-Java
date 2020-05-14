package be.isims.ihm.dp.tp5.ex1.code;

import java.util.ArrayList;

public class PizzaDecorator implements Pizza {

    protected Pizza pizzaADecorer;
    protected double prix;

    public PizzaDecorator(Pizza base) {
        this.pizzaADecorer = base;
    }

    @Override
    public double calculePrix() {
        this.prix += this.pizzaADecorer.calculePrix();
        return this.prix;
    }

    @Override
    public void afficheDescription() {
        this.pizzaADecorer.afficheDescription();
        System.out.println(this.getClass().getSimpleName());
    }

    public double getPrix() {
        return this.calculePrix();
    }
}
