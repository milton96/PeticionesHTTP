package main.models;

public class Geo {
    public String lat;
    public String lng;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLat(String lat) {
        //this.lat = Float.parseFloat(lat);
        this.lat = lat;
    }

    public void setLng(String lng) {
        //this.lng = Float.parseFloat(lng);
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
