package com.example.george.lolapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.util.Log;

import com.example.george.lolapp.Adapter.DataAdapter;
import com.example.george.lolapp.ManagerService.ManagerService;
import com.example.george.lolapp.Modelo.Campeon.Descripcion;
import com.example.george.lolapp.Modelo.Campeon.JsonDataChamps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Champs extends AppCompatActivity {

    RecyclerView mRecyclerView;
    DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champs);
        initViews();


    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        loadJSON();

    }


    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ddragon.leagueoflegends.com/cdn/8.15.1/data/es_MX/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ManagerService service = retrofit.create(ManagerService.class);
        Call<JsonDataChamps> campeones = service.getCampeones();
        campeones.enqueue(new Callback<JsonDataChamps>() {
            @Override
            public void onResponse(Call<JsonDataChamps> call, Response<JsonDataChamps> response) {

                if (response.isSuccessful()){



                    Map<String, Descripcion> data = response.body().getData();

                    Log.e("TAG","campeones => " + data.size());

                    mAdapter = new DataAdapter(data);
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    for (Map.Entry<String, Descripcion> campeon : data.entrySet()){
//                        Log.d("TAG", "campeon => " + entry.getKey() + " / " + entry.getValue());
//                        Log.e("TAG", campeon.getValue());
//                       Log.e("TAG", campeon.getValue().getInfo().getAttack());
//                       Log.e("TAG", campeon.getValue().getName());
//                       Log.e("TAG", campeon.getValue().getTitle());
//                       Log.e("TAG", campeon.getValue().getBlurb());
//                       Log.e("TAG", campeon.getValue().getId());




                       //codo = data.get(nombreCampeon);




                    }



//                    JsonDataChamps campeones = response.body();
//                    for (int i = 0; i < campeones.getData().size(); i++){
//                        Log.d("listado", "champs :" + campeones.getData().get(i));
//                    }
//                    Log.d("data", "campeones => " + data.get("Aatrox"));
//                    Log.d("version", "version => " +campeones.getVersion());
                }

             /*   try {
                    ArrayList<Descripcion> camps = response.body().getData();
                    for (int i = 0; i < camps.size(); i++){
                        Log.d("TAG", "hola" + camps.get(i).getName());
                    }
                    adapter = new DataAdapter(data);
                    recyclerView.setAdapter(adapter);

                }catch (Exception e){
                    e.printStackTrace();
                }*/

            }

            @Override
            public void onFailure(Call<JsonDataChamps> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

}
