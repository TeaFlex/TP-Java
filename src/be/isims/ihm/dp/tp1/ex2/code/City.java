package be.isims.ihm.dp.tp1.ex2.code;

public class City extends Province { //node

    private Province province;

    public City(String name, int profit) {
        super(name, profit);
    }

    public void addStore(Province p) {
        province=p;
    }

    @Override
    public int getProfit(){
        return this.profit+province.getProfit();
    }

}
