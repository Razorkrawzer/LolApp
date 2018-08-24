package com.example.george.lolapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        getSupportActionBar().hide();


        prefs = this.getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        iconoPerfil = getIconoId();
        nombrePerfil = getNombre();
        nivelPerfil = getNivel();


        ImageView iconoInvocador = findViewById(R.id.iconoPerfil);
        TextView nombreInvocador = findViewById(R.id.nombrePerfil);
        TextView nivelInvocador = findViewById(R.id.nivelPerfil);
        Button btn_campeones = findViewById(R.id.btn_campeones);




        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/8.16.1/img/profileicon/"+iconoPerfil+".png").into(iconoInvocador);
        nombreInvocador.setText(nombrePerfil);
        nivelInvocador.setText(nivelPerfil);

        btn_campeones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Perfil.this, Champs.class));



            }
        });







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
