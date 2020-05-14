package be.isims.ihm.dp.tp4.ex5.code;

import be.isims.ihm.dp.tp4.ex5.code.AbstractObservable;

//MODELE
public class ColorModel extends AbstractObservable {

    private String hr, hg, hb;
    @Override
    public void toHex(int r, int g, int b) {
        this.hr = this.correction(r);
        this.hg = this.correction(g);
        this.hb = this.correction(b);
        this.observer.update(hr+hg+hb);
    }

    private String correction(int in) {
        return (String.valueOf(in).length()<2 ? "0"+Integer.toHexString(in) : Integer.toHexString(in)).toUpperCase();
    }
}
