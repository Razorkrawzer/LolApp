package com.example.george.lolapp.Modelo;

/**
 * Created by georg on 14/01/2018.
 */

public class Campeon {

    int id;
    boolean active;
    boolean botEnabled;
    boolean freeToPlay;
    boolean botMmEnabled;
    boolean rankedPlayEnabled;

    public Campeon(int id, boolean active, boolean botEnabled, boolean freeToPlay, boolean botMmEnabled, boolean rankedPlayEnabled) {
        this.id = id;
        this.active = active;
        this.botEnabled = botEnabled;
        this.freeToPlay = freeToPlay;
        this.botMmEnabled = botMmEnabled;
        this.rankedPlayEnabled = rankedPlayEnabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBotEnabled() {
        return botEnabled;
    }

    public void setBotEnabled(boolean botEnabled) {
        this.botEnabled = botEnabled;
    }

    public boolean isFreeToPlay() {
        return freeToPlay;
    }

    public void setFreeToPlay(boolean freeToPlay) {
        this.freeToPlay = freeToPlay;
    }

    public boolean isBotMmEnabled() {
        return botMmEnabled;
    }

    public void setBotMmEnabled(boolean botMmEnabled) {
        this.botMmEnabled = botMmEnabled;
    }

    public boolean isRankedPlayEnabled() {
        return rankedPlayEnabled;
    }

    public void setRankedPlayEnabled(boolean rankedPlayEnabled) {
        this.rankedPlayEnabled = rankedPlayEnabled;
    }
}
