package be.isims.ihm.dp.tp4.ex4.code;

import be.isims.ihm.dp.tp4.ex4.code.AbstractController;
import be.isims.ihm.dp.tp4.ex4.code.AbstractModel;

public class ConverterController extends AbstractController {

    public  ConverterController(AbstractModel am) {
        super(am);
    }

    public void setValue(String value, String target) {
        try{
            this.am.convertcurrency(value, target, target.equals("EUR") ? "0.98" : "1.08");
        }
        catch(Exception e){
            //TODO: faire erreur
        }
    }

    public void setValue(String value, String target, String rate) {
        try {
            this.am.converttaxes(value, target, rate);
        }
        catch (Exception e){
            //TODO: faire erreur
        }
    }
}
