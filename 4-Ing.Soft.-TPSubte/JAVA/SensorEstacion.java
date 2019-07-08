package com.company;

public class SensorEstacion {

    //atributos

    private String estacion;
    private boolean hayTren;


    public SensorEstacion(String estacion, boolean hayTren) {
        this.estacion = estacion;
        this.hayTren = hayTren;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public boolean getHayTren() {
        return hayTren;
    }

    public void setHayTren(boolean hayTren) {
        this.hayTren = hayTren;
    }
}
