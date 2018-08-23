package com.example.george.lolapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class CodigoAccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_access);
        getSupportActionBar().hide();

        Button btn_acceso = findViewById(R.id.btn_codigo);
        final EditText codigoInput = findViewById(R.id.inputCodigo);

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

        String editText = null;
         CodigoAsync(String valor) {
            editText = valor;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            String api = "";
            try {
                URL url = new URL("https://us-central1-lol-admin-8adb1.cloudfunctions.net/app/"+editText);
                Log.d("url" ,url.toString());
                InputStream is = url.openStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String line;
                while ( (line = br.readLine()) != null)
                    System.out.println(line);

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
}
