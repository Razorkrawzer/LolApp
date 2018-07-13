package com.example.george.lolapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.george.lolapp.ManagerService.ManagerService;
import com.example.george.lolapp.Modelo.Profile;
import com.example.george.lolapp.Personajes.Perfil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textoNombreInvocador;
    Button btnBuscar;
    EditText invocador;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textoNombreInvocador = (TextView) findViewById(R.id.texto1);
       // textoNombreInvocador.setText("Nombre");
        btnBuscar = (Button) findViewById(R.id.btn_acceder);
        invocador = (EditText) findViewById(R.id.nombreInvocador);

        prefs = this.getSharedPreferences("Preferences", Context.MODE_PRIVATE);




        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String nombreInvocador = invocador.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://la1.api.riotgames.com/lol/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ManagerService service = retrofit.create(ManagerService.class);
                Call<Profile> perfil = service.getProfile(nombreInvocador);
                perfil.enqueue(new Callback<Profile>() {
                    @Override
                    public void onResponse(Call<Profile> call, Response<Profile> response) {
                        try {

                            if (response.body() != null){
                                Log.d("respuesta", response.body().toString());
                                Profile Invocador = response.body();
                                Log.d("nombre", Invocador.getName());
//                            InvocadorText.setText(Invocador.getName());
                                Log.d("nivel", String.valueOf(response.body().getSummonerLevel()));
//                            nivelText.setText(String.valueOf(Invocador.getSummonerLevel()));
                                Log.d("icono", String.valueOf(Invocador.getProfileIconId()));

                                startActivity(new Intent(MainActivity.this, Perfil.class));

                                saveNombre(String.valueOf(Invocador.getName()));
                                saveNivel(String.valueOf(Invocador.getSummonerLevel()));
                                saveIcono(String.valueOf(Invocador.getProfileIconId()));


                            } else if (invocador.length() <= 0 ){
                                Toast.makeText(getApplicationContext(), "Escribe un usuario", Toast.LENGTH_LONG).show();

                            } else{
                                Toast.makeText(getApplicationContext(), "No existe Invocador", Toast.LENGTH_SHORT).show();
                            }


                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Invocador invalido", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<Profile> call, Throwable t) {
                        Log.d("OnFailure", t.toString());
                    }
                });

            }
        });


    }  // termina OnCreate

    private void saveIcono(String icono){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("icono", icono);
        editor.apply();
    }

    private void saveNombre(String nombre){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre", nombre);
        editor.apply();
    }

    private void saveNivel(String nivel){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nivel", nivel);
        editor.apply();
    }

    private String getIcono(){
        return prefs.getString("icono", "");
    }


}
