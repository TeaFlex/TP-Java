package be.isims.ihm.dp.tp4.ex5.code;

import be.isims.ihm.dp.tp4.ex5.code.AbstractController;
import be.isims.ihm.dp.tp4.ex5.code.AbstractObservable;

//CONTROLLEUR
public class Controller extends AbstractController {

    public Controller(AbstractObservable observable) {
        super(observable);
    }

    @Override
    public void notification(int r, int g, int b) {
        this.observable.toHex(r>255 || r<0 ? 0 : r, g>255 || g<0 ? 0 : g, b>255 || b<0 ? 0 : b);
    }
}
