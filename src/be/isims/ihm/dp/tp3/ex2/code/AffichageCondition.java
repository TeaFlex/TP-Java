package be.isims.ihm.dp.tp3.ex2.code;

public class AffichageCondition implements Affichage {

    private StationMeteo station;

    public AffichageCondition(StationMeteo station){
        this.station = station;
    }
    @Override
    public void update(){
        System.out.println("Température: "+station.getTemperatureMax()+"°C | Humidité: "+station.getHumidite()+"% ");
    }
}
