package be.isims.ihm.dp.tp4.ex3.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CalculatriceObserveur {

    private CalculatriceFrm fenetre;

    public CalculatriceObserveur(CalculatriceFrm f) {
        this.fenetre = f;
    }

    public void update(String valeur) {
        try{
            if(valeur == "="){
                List<String> res = Arrays.asList(fenetre.getCalcul().split("((?<=[+/*-])|(?=[+/*-]))"));
                if(Arrays.asList(Calculatrice.operations).contains(res.get(0))){
                    if(res.get(0).equals('-') || res.get(0).equals('+')){
                        List<String> l = new ArrayList<>();
                        l.add("0");
                        for(String s : res) l.add(s);
                        res = l;
                    }
                    else throw new Exception();
                }
                String temp = res.get(0);
                for(int i = 0; i<res.size()-1; i+=2)  temp = Calculatrice.operation(res.get(i+1),
                        Double.parseDouble(temp),
                        Double.parseDouble(res.get(i+2))).toString();
                if(!Arrays.asList(Calculatrice.operations).contains(fenetre.getCalcul()))
                    fenetre.setResultat("="+temp);
                else throw new Exception();

            }
            else if(valeur == "C"){
                fenetre.setCalcul("");
                fenetre.setResultat("");
            }
            else fenetre.ajoutCalcul(valeur);
        }
        catch (Exception e){
            fenetre.getResultat().setText("ERREUR");
        }
    }
}
