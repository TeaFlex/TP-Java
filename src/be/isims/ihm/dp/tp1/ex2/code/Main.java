package be.isims.ihm.dp.tp1.ex2.code;

public class Main {
    public static void main(String[] args) {
        Store store1 = new Store("Ikea", 100);
        City city = new City("Mons", 560);
        city.addStore(store1);
        System.out.println("Profit: "+city.getProfit()+"€");
    }
}
