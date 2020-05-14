package be.isims.ihm.dp.tp4.ex6.code;

public abstract class AbstractController {

    protected AbstractModel model;

    public AbstractController(AbstractModel model) {
        this.model = model;
    }

    public abstract void notification(String value, String operation);
}
