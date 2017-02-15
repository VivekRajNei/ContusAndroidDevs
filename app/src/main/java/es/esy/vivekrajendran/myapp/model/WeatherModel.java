package es.esy.vivekrajendran.myapp.model;


public class WeatherModel {

    private String url;
    private String place;
    private String mag;
    private String detail;
    private long time;

    public WeatherModel(String url, String place, String mag, String detail, long time) {
        this.url = url;
        this.place = place;
        this.mag = mag;
        this.detail = detail;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
