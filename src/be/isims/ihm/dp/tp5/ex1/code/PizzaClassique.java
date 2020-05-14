package be.isims.ihm.dp.tp5.ex1.code;

public class PizzaClassique implements Pizza {

    private double prix = 5;

    @Override
    public double calculePrix() {
        return this.prix;
    }

    @Override
    public void afficheDescription() {
        System.out.println(this.getClass().getSimpleName());
    }
}
