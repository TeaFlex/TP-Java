package be.isims.ihm.dp.tp2.ex2.code;

public class Client {
    public static void main(String[] args) {
        String txt="6";
        System.out.println("La chaine de caractère : "+txt);
        Validator valEntier=new Validator(new IntegerFormat(),txt);
        System.out.println("Est-ce que "+txt+ " est un entier valide ? "+valEntier.isValid() );
        Validator valMail=new Validator(new EmailFormat(),txt);
        System.out.println("Est-ce que "+txt+ " est un mail valide ? "+valMail.isValid() );
        System.out.println("----------------------");
        txt="toto@gmail.com";
        System.out.println("La chaine de caractère : "+txt);
        Validator valEntier2=new Validator(new IntegerFormat(),txt);
        System.out.println("Est-ce que "+txt+ " est un entier valide ? "+valEntier2.isValid() );
        Validator valMail2=new Validator(new EmailFormat(),txt);
        System.out.println("Est-ce que "+txt+ " est un mail valide ? "+valMail2.isValid() );
    }
}
