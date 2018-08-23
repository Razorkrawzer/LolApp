package com.example.george.lolapp.Modelo.Campeon;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class JsonDataChamps {

    private String version;
    @SerializedName("data")
    private Map<String, Descripcion> data;


    public Map<String, Descripcion> getData() {
        return data;
    }

    public void setData(Map<String, Descripcion> data) {
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }



}

