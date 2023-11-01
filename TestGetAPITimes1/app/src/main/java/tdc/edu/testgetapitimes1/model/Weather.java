package tdc.edu.testgetapitimes1.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Weather {
    @SerializedName("wind")
    Wind wind;
    @SerializedName("visibility")
    public float tamNhinXa;
    @SerializedName("dt_txt")
    public String dt_txt;
    @SerializedName("main")
    Main main;
    @SerializedName("weather")
    ArrayList<weatherItem> weatherItems;


    public Weather(Wind wind, float tamNhinXa, String dt_txt, Main main, ArrayList<weatherItem> weatherItems) {
        this.wind = wind;
        this.tamNhinXa = tamNhinXa;
        this.dt_txt = dt_txt;
        this.main = main;
        this.weatherItems = weatherItems;
    }


    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public float getTamNhinXa() {
        return tamNhinXa;
    }

    public void setTamNhinXa(float tamNhinXa) {
        this.tamNhinXa = tamNhinXa;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ArrayList<weatherItem> getWeatherItems() {
        return weatherItems;
    }

    public void setWeatherItems(ArrayList<weatherItem> weatherItems) {
        this.weatherItems = weatherItems;
    }

    public class Wind {
        @SerializedName("speed")
        public float tocDoGio;

        public Wind(float tocDoGio) {
            this.tocDoGio = tocDoGio;
        }

        public float getTocDoGio() {
            return tocDoGio;
        }

        public void setTocDoGio(float tocDoGio) {
            this.tocDoGio = tocDoGio;
        }
    }

    public class Main {
        @SerializedName("temp_min")
        public float nhietDoMin;
        @SerializedName("temp_max")
        public float nhietDoMax;
    }

    public class weatherItem {
        @SerializedName("main")
        public String weather;

        public weatherItem(String weather) {
            this.weather = weather;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "wind=" + wind +
                ", tamNhinXa=" + tamNhinXa +
                ", dt_txt='" + dt_txt + '\'' +
                ", main=" + main +
                ", weatherItems=" + weatherItems +
                '}';
    }
}
