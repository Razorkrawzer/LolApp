package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.Campeones.ListaCampeones;
import com.example.george.lolapp.Modelo.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {

    @GET("summoner/v3/summoners/by-name/{usuario}?api_key=RGAPI-b4846e7f-3c71-4ebe-927b-b1a131390e66")
    Call<Profile> getProfile(@Path("usuario") String usuario);

    @GET("static-data/v3/champions?locale=es_MX&version=8.14.1&dataById=false&api_key=RGAPI-b4846e7f-3c71-4ebe-927b-b1a131390e66")
    Call<ListaCampeones> getCampeones();



}
