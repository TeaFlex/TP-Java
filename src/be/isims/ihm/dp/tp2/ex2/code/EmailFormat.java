package be.isims.ihm.dp.tp2.ex2.code;

public class EmailFormat implements Format {
    @Override
    public boolean verify(String input) {
        return input.indexOf("@")<input.indexOf(".") && input.contains("@") && input.contains(".")? true : false;
    }
}
