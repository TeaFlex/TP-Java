package be.isims.ihm.dp.tp4.ex3.code;

public class Calculatrice {

    public static String operations[] = {"+","-","/","*","C"};

    public static Double operation(String o, double a, double b) {
        switch (o){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "/":
                return a/b;
            case "*":
                return a*b;
            default:
                return 0.0;
        }
    }
}
