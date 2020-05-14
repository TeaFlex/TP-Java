package be.isims.ihm.dp.tp3.ex1.code;

public class ConvHex implements Conversion {

    private Nombre n;

    public ConvHex(Nombre n) {
        this.n = n;
    }
    @Override
    public void actualise(){
        System.out.println("Hexadécimal: "+Integer.toHexString(n.getNombre()));
    }
}
