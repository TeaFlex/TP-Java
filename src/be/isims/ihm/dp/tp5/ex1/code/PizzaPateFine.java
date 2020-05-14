package be.isims.ihm.dp.tp5.ex1.code;

public class PizzaPateFine implements Pizza {

    private double prix = 6;

    @Override
    public double calculePrix() {
        return this.prix;
    }

    @Override
    public void afficheDescription() {
        System.out.println(this.getClass().getSimpleName());
    }
}
