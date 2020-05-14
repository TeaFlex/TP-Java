package be.isims.ihm.dp.tp3.ex1.code;

public class Saisi extends Nombre {

    private int nombre;

    @Override
    public void setNombre(int nombre) {
        this.nombre = nombre;
        notifie();
    }

    @Override
    public int getNombre() {
        return nombre;
    }
}
