package com.example.george.lolapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.george.lolapp.Modelo.Codigo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class CodigoAccess extends AppCompatActivity {
    String token;
    String c = "razor-kophexo";
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_access);
        getSupportActionBar().hide();

        Button btn_acceso = findViewById(R.id.btn_codigo);
        final EditText codigoInput = findViewById(R.id.inputCodigo);

        preferences = this.getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        btn_acceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new CodigoAsync(codigoInput.getText().toString()).execute();





//                Intent intent = new Intent(CodigoAccess.this, MainActivity.class);
//                startActivity(intent);
            }
        });

    }

    public class CodigoAsync extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog = null;
        String editText = null;

         CodigoAsync(String valor) {
            editText = valor;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(CodigoAccess.this, "Cargando", "");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            if (editText.equals(c)){
                Intent main = new Intent(CodigoAccess.this, MainActivity.class);
                startActivity(main);
            }else if (editText.matches("")){
                Toast.makeText(CodigoAccess.this, "Ingresa el código", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(CodigoAccess.this, "Código inválido", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL("https://us-central1-lol-admin-8adb1.cloudfunctions.net/app/"+editText);
                Log.d("url" ,url.toString());
                InputStream is = url.openStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));


                while ( (token = br.readLine()) != null)
                saveToken(String.valueOf(token));



                br.close();
                is.close();
            }catch (Exception e){
                e.printStackTrace();
                Log.d("conexion", e.getMessage());
//            Toast.makeText(getApplicationContext(), "error" +e.getMessage(), Toast.LENGTH_LONG).show();
            }

            return null;
        }
    }

    private void saveToken(String token){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token);
        editor.apply();
    }
}
