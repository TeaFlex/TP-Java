package be.isims.ihm.dp.tp6.ex1.code;

public class Main {
    public static void main(String[] args) {
        int[] entiers1 = {1,5,6,3,8,3,7};
        int[] entiers2 = {2,5,6,12,4,55,4};
        char[] operateurs = {'*','+','-','/','*','/','+'};
        GenerateurFichier gen = new GenerateurFichier();
        gen.stockerNombre("operande1.dat", entiers1);
        gen.stockerNombre("operande2.dat", entiers2);
        gen.stockerCaracteres("operateurs.dat", operateurs);
        CalculFichier c = new CalculFichier();
        c.lireFichier();
    }
}
