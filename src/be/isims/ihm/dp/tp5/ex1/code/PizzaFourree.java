package be.isims.ihm.dp.tp5.ex1.code;

public class PizzaFourree implements Pizza {

    private double prix = 7;

    @Override
    public double calculePrix() {
        return this.prix;
    }

    @Override
    public void afficheDescription() {
        System.out.println(this.getClass().getSimpleName());
    }
}
