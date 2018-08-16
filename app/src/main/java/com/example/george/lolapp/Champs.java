package com.example.george.lolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.george.lolapp.Adapter.DataAdapter;
import com.example.george.lolapp.ManagerService.ManagerService;
import com.example.george.lolapp.Modelo.Campeones.Campeones;
import com.example.george.lolapp.Modelo.Campeones.ListaCampeones;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Champs extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Campeones> data;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champs);
        initViews();
    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://la1.api.riotgames.com/lol/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ManagerService service = retrofit.create(ManagerService.class);
        Call<ListaCampeones> campeones = service.getCampeones();
        campeones.enqueue(new Callback<ListaCampeones>() {
            @Override
            public void onResponse(Call<ListaCampeones> call, Response<ListaCampeones> response) {

                try {
                    ArrayList<Campeones> camps = response.body().getData();
                    for (int i = 0; i < camps.size(); i++){
                        Log.d("TAG", "hola" + camps.get(i).getName());
                    }
                    adapter = new DataAdapter(data);
                    recyclerView.setAdapter(adapter);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ListaCampeones> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
