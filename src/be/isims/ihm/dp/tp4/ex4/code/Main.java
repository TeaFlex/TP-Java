package be.isims.ihm.dp.tp4.ex4.code;

public class Main {
    public static void main(String[] args) {
        AbstractModel conv = new Converter();

        AbstractController con = new ConverterController(conv);

        ConverterFrm n = new ConverterFrm(con);

        conv.addObserver(n);
    }
}
