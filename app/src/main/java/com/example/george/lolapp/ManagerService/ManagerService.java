package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.Campeones.ListaCampeones;
import com.example.george.lolapp.Modelo.Profile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {

    @GET("summoner/v3/summoners/by-name/{usuario}?api_key=RGAPI-007f30fd-c429-465c-9544-3a29a72452ab")
    Call<Profile> getProfile(@Path("usuario") String usuario);

    @GET("champion.json")
    Call<ListaCampeones> getCampeones();



}
