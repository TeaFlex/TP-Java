package be.isims.ihm.dp.tp4.ex4.code;

import be.isims.ihm.dp.tp4.ex4.code.AbstractModel;

public abstract class AbstractController {

    protected AbstractModel am;

    public AbstractController(AbstractModel am) {
        this.am = am;
    }

    public abstract void setValue(String value, String target);
    public abstract void setValue(String value, String target, String rate);
}
