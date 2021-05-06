package main.models;

public class Geo {
    public float lat;
    public float lng;

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLat(String lat) {
        this.lat = Float.parseFloat(lat);
    }

    public void setLng(String lng) {
        this.lng = Float.parseFloat(lng);
    }
}
