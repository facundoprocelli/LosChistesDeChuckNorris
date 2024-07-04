package org.example.Module;

public class Chiste {

    private String id;
    private String value;
    private String puntuacion;


    public Chiste(String id, String value, String puntuacion) {
        this.id = id;
        this.value = value;
        this.puntuacion = puntuacion;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }



}
