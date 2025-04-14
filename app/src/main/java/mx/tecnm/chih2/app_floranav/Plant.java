package mx.tecnm.chih2.app_floranav;

import java.util.Date;

public class Plant {
    private String name;
    private String characteristics;
    private double latitude;
    private double longitude;
    private Date timestamp;

    public Plant() {
        // Constructor vacío requerido por Firestore
    }

    public Plant(String name, String characteristics, double latitude, double longitude, Date timestamp) {
        this.name = name;
        this.characteristics = characteristics;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    // Getters y Setters completos
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
