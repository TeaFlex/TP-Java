package be.isims.ihm.dp.tp1.ex1.code;

public class Number extends Operation {

    public Number(int value){
        this.result = value;
    }

    public String toString() {
        return String.valueOf(this.result);
    }
}
