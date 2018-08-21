package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.Campeon.ListaCampeones;
import com.example.george.lolapp.Modelo.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {

    @GET("summoner/v3/summoners/by-name/{usuario}?api_key=RGAPI-10467933-9e7f-483f-912c-289ae0ab5338")
    Call<Profile> getProfile(@Path("usuario") String usuario);

    @GET("champion.json")
    Call<ListaCampeones> getCampeones();



}
