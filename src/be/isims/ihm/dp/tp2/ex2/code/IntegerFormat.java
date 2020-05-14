package be.isims.ihm.dp.tp2.ex2.code;

public class IntegerFormat implements Format {
    @Override
    public boolean verify(String input) {
        try{
            Integer.parseInt(input);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
