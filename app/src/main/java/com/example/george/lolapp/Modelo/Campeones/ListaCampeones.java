package com.example.george.lolapp.Modelo.Campeones;

import java.util.ArrayList;
import java.util.Map;

public class ListaCampeones {

    private String version;
    private ArrayList<Campeones> data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ArrayList<Campeones> getData() {
        return data;
    }

    public void setData(ArrayList<Campeones> data) {
        this.data = data;
    }
}
