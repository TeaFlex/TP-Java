package be.isims.ihm.dp.tp5.ex1.code;

public class Main {
    public static void main(String[] args) {
        PizzaDecorator p = new PizzaDecorator(new Olive(new Jambon(new Thon(new PizzaClassique()))));
        p.afficheDescription();
        System.out.println(p.getPrix()+" €");
    }
}
