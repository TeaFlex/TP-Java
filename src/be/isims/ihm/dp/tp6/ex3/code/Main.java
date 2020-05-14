package be.isims.ihm.dp.tp6.ex3.code;

public class Main {
    public static void main(String[] args) {
        FichierTab ft = new FichierTab(20, "tabInteger");
        ft.ecrire(0, 12);
        ft.ecrire(5, 34);
        ft.ecrire(10, 100);

        System.out.println("Indice 0 : "+ft.lire(0));
        System.out.println("Indice 5 : "+ft.lire(5));
        System.out.println("Indice 10 : "+ft.lire(10));
    }
}
