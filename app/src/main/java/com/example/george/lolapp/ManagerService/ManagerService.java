package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.Campeon.JsonDataChamps;
import com.example.george.lolapp.Modelo.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {

    @GET("summoner/v3/summoners/by-name/{usuario}?api_key=RGAPI-632f616c-102e-45bf-8e2c-9f6274b8e801")
    Call<Profile> getProfile(@Path("usuario") String usuario);

    @GET("champion.json")
    Call<JsonDataChamps> getCampeones();



}
