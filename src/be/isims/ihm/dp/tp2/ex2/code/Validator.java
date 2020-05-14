package be.isims.ihm.dp.tp2.ex2.code;

public class Validator {

    private Format format;
    private String input;

    public Validator(Format format, String input) {
        this.format = format;
        this.input = input;
    }

    public boolean isValid() {
        return this.format.verify(input);
    }
}
