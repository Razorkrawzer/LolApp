package com.example.george.lolapp.Personajes;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.george.lolapp.MainActivity;
import com.example.george.lolapp.ManagerService.ManagerService;
import com.example.george.lolapp.Modelo.IconosPerfil.Iconos;
import com.example.george.lolapp.Modelo.IconosPerfil.IconosPersonajes;
import com.example.george.lolapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Perfil extends AppCompatActivity {

    final static String TAG = Perfil.class.getName();

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

        iconoPerfil = getIconoId();
        nombrePerfil = getNombre();
        nivelPerfil = getNivel();


        ImageView iconoInvocador = findViewById(R.id.iconoPerfil);
        TextView nombreInvocador = findViewById(R.id.nombrePerfil);
        TextView nivelInvocador = findViewById(R.id.nivelPerfil);


        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/8.14.1/img/profileicon/"+iconoPerfil+".png").into(iconoInvocador);
        nombreInvocador.setText(nombrePerfil);
        nivelInvocador.setText(nivelPerfil);







    }

    private void saveIcono(String icono){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("icono", icono);
        editor.apply();
    }

    private String getIconoId(){
        return prefs.getString("icono", "");
    }

    private String getNombre(){
        return prefs.getString("nombre", "");
    }

    private String getNivel(){
        return prefs.getString("nivel", "");
    }
}
