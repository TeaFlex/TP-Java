package be.isims.ihm.dp.tp1.ex2.code;

public abstract class Province{ //root
    protected String name;
    protected int profit;

    public Province(String name, int profit) {
        this.profit = profit;
        this.name = name;
    }
    public void setProfit(int profit){
        this.profit = profit;
    }

    public int getProfit(){
        return profit;
    }
}
