package be.isims.ihm.dp.tp4.ex5.code;

//CONTROLLEUR
public abstract class AbstractController {
    protected AbstractObservable observable;

    public AbstractController(AbstractObservable observable) {
        this.observable = observable;
    }

    public abstract void notification(int r, int g, int b);
}
