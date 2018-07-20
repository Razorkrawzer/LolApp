package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.IconosPerfil.Iconos;
import com.example.george.lolapp.Modelo.IconosPerfil.IconosPersonajes;
import com.example.george.lolapp.Modelo.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {

    @GET("summoner/v3/summoners/by-name/{usuario}?api_key=RGAPI-a6b5f9b3-57de-4750-881f-a1a88d507afa")
    Call<Profile> getProfile(@Path("usuario") String usuario);

    @GET("cdn/8.14.1/img/profileicon/{id}.png")
    Call<Iconos> getProfileIcon(@Path("id") int id);


}
