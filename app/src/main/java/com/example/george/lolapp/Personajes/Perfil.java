package com.example.george.lolapp.Personajes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.george.lolapp.MainActivity;
import com.example.george.lolapp.ManagerService.ManagerService;
import com.example.george.lolapp.Modelo.Profile;
import com.example.george.lolapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Perfil extends AppCompatActivity {

    String nombreInvocador, nivelInvocador;
    TextView InvocadorText;
    String iconoPerfil, nombrePerfil, nivelPerfil;
    TextView nivelText;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        prefs = this.getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        iconoPerfil = getIcono();
        nombrePerfil = getNombre();
        nivelPerfil = getNivel();


        ImageView iconoPerfil = findViewById(R.id.iconoPerfil);
        TextView nombreInvocador = findViewById(R.id.nombrePerfil);
        TextView nivelInvocador = findViewById(R.id.nivelPerfil);

        nombreInvocador.setText(getNombre());
        nivelInvocador.setText(getNivel());






    }

    private void saveIcono(String icono){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("icono", icono);
        editor.apply();
    }

    private String getIcono(){
        return prefs.getString("icono", "");
    }

    private String getNombre(){
        return prefs.getString("nombre", "");
    }

    private String getNivel(){
        return prefs.getString("nivel", "");
    }
}
