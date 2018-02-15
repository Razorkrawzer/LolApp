package com.example.george.lolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.george.lolapp.Personajes.ListaPersonajes;

public class MainActivity extends AppCompatActivity {

    TextView textoNombreInvocador;
    Button btnBuscar;
    EditText invocador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNombreInvocador = (TextView) findViewById(R.id.texto1);
       // textoNombreInvocador.setText("Nombre");
        btnBuscar = (Button) findViewById(R.id.btn_acceder);
        invocador = (EditText) findViewById(R.id.nombreInvocador);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("resultado", "hola mundo");
                if (invocador.length() <= 0 ){
                    Toast.makeText(getApplicationContext(), "Escribe un usuario", Toast.LENGTH_LONG).show();

                }else {
                    Intent siguienteActivity = new Intent(getApplication(), ListaPersonajes.class);
                    siguienteActivity.putExtra("nombre", invocador.getText().toString());
                    startActivity(siguienteActivity);


                }

            }
        });
    }
}
