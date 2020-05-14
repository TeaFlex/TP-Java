package be.isims.ihm.dp.tp1.ex1.code;

public class Main {
    public static void main(String[] args) {
            BinaryExpression b = new BinaryExpression(
                    new BinaryExpression(new Number(41), new Number(5)),
                    new Number(8));
            System.out.println(b);
    }
}
