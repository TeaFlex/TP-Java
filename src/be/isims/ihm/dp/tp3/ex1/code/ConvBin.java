package be.isims.ihm.dp.tp3.ex1.code;

public class ConvBin implements Conversion {

    private Nombre n;

    public ConvBin(Nombre n) {
        this.n = n;
    }
    @Override
    public void actualise(){
        System.out.println("Binaire: "+Integer.toBinaryString(n.getNombre()));
    }
}
