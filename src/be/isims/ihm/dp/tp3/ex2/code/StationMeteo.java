package be.isims.ihm.dp.tp3.ex2.code;

public class StationMeteo extends Station {
    private float humidite;
    private float temperatureMax;
    private float temperatureMin = 20;
    private float temperatureMoyenne;

    public void ajouterDonnees(float humidite, float temperatureMax){
        this.humidite = humidite;
        this.temperatureMax = temperatureMax;
        this.notifier();
    }

    public float getTemperatureMoyenne() {
        return temperatureMoyenne;
    }

    public float getTemperatureMin() {
        return temperatureMin;
    }

    public float getHumidite() {
        return humidite;
    }

    public float getTemperatureMax() {
        return temperatureMax;
    }
}
