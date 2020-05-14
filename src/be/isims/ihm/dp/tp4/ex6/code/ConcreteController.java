package be.isims.ihm.dp.tp4.ex6.code;

public class ConcreteController extends AbstractController {

    public ConcreteController(AbstractModel model) {
        super(model);
    }

    @Override
    public void notification(String value, String operation){
        try {
            this.model.getTemperature(Integer.parseInt(value), operation);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
