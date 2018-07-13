package com.example.george.lolapp.ManagerService;

import com.example.george.lolapp.Modelo.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georg on 13/01/2018.
 */

public interface ManagerService {

    @GET("summoner/v3/summoners/by-name/{usuario}?api_key=RGAPI-d789e52b-5783-4c78-8ac6-c0ef0e0130d0")
    Call<Profile> getProfile(@Path("usuario") String usuario);


}
