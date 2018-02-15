package com.example.george.lolapp.Personajes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.george.lolapp.ManagerService.ManagerService;
import com.example.george.lolapp.Modelo.Profile;
import com.example.george.lolapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaPersonajes extends AppCompatActivity {

    String nombreInvocador;
    TextView InvocadorText;
    String informacion;
    TextView nivelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personajes);

        InvocadorText = (TextView) findViewById(R.id.Nombre);
        nivelText = (TextView) findViewById(R.id.Nivel);

        nombreInvocador = getIntent().getExtras().getString("nombre");
        Log.d("resultado", nombreInvocador);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://la1.api.riotgames.com/lol/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ManagerService service = retrofit.create(ManagerService.class);
        Call<Profile> perfil = service.getProfile(nombreInvocador);
        perfil.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.body() != null){
                    Log.d("respuesta", response.body().toString());
                    Profile Invocador = response.body();
                    Log.d("nombre", Invocador.getName());
                    InvocadorText.setText(Invocador.getName());
                    Log.d("infolvl", String.valueOf(response.body().getSummonerLevel()));


                }else {
                    Toast.makeText(getApplicationContext(), "Invocador invalido", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });

    }
}
