package es.esy.vivekrajendran.myapp.model;


public class WeatherModel {


    private String lat;
    private String lon;
    private String location;
    private String description;
    private long temp;
    private long humidity;

    public WeatherModel(String lat, String lon, String location, String description, long temp, long humidity) {
        this.lat = lat;
        this.lon = lon;
        this.location = location;
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTemp() {
        return temp;
    }

    public void setTemp(long temp) {
        this.temp = temp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }
}
