package org.example.Module;

public class Chiste {

    private String id;
    private String chiste;
    private String puntuacion;


    public Chiste(String id, String chiste, String puntuacion) {
        this.id = id;
        this.chiste = chiste;
        this.puntuacion = puntuacion;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChiste() {
        return chiste;
    }

    public void setChiste(String chiste) {
        this.chiste = chiste;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }



}
