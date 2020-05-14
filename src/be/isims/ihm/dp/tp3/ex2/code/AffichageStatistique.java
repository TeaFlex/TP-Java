package be.isims.ihm.dp.tp3.ex2.code;

public class AffichageStatistique implements Affichage {

    private StationMeteo station;

    public AffichageStatistique(StationMeteo station){
        this.station = station;
    }
    @Override
    public void update(){
        System.out.println(" >>> Min: "+station.getTemperatureMin()+"°C |  Max: "+station.getTemperatureMax()+"°C | Moyenne: "+ (station.getTemperatureMax()+station.getTemperatureMin())/2+"°C");
    }
}
