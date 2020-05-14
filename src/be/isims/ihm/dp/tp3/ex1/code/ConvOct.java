package be.isims.ihm.dp.tp3.ex1.code;

public class ConvOct implements Conversion {

    private Nombre n;

    public ConvOct(Nombre n){
        this.n = n;
    }
    @Override
    public void actualise(){
        System.out.println("Octal: "+Integer.toOctalString(n.getNombre()));
    }
}
