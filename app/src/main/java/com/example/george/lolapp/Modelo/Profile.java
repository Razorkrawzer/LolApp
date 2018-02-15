package com.example.george.lolapp.Modelo;

/**
 * Created by georg on 13/01/2018.
 */

public class Profile {

    int id;
    int accountId;
    String name;
    int profileIconId;
    double revisionDate;
    int summonerLevel;

    public Profile(int id, int accountId, String name, int profileIconId, double revisionDate, int summonerLevel) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerLevel = summonerLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public double getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(double revisionDate) {
        this.revisionDate = revisionDate;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }
}
