package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.Campeon.JsonDataChamps;
import com.example.george.lolapp.Modelo.Codigo;
import com.example.george.lolapp.Modelo.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {




    @GET("summoner/v3/summoners/by-name/{usuario}?")
    Call<Profile> getProfile(@Path("usuario") String usuario, @Query("api_key") String token);

    @GET("champion.json")
    Call<JsonDataChamps> getCampeones();






}
