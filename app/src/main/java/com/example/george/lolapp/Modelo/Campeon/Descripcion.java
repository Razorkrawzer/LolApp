package com.example.george.lolapp.Modelo.Campeon;

public class Descripcion {

    private String id;
    private String name;
    private String title;
    private String blurb;
    private InfoChamp info;
    private ImagenChamp image;

    public InfoChamp getInfo() {
        return info;
    }

    public void setInfo(InfoChamp info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
