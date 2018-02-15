package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {

    @GET("summoner/v3/summoners/by-name/{usuario}?api_key=RGAPI-32900a06-ee60-4018-b54b-512ca20ed2d8")
    Call<Profile> getProfile(@Path("usuario") String usuario);
}
