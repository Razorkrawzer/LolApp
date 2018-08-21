package com.example.george.lolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.george.lolapp.Adapter.DataAdapter;
import com.example.george.lolapp.ManagerService.ManagerService;
import com.example.george.lolapp.Modelo.Campeon.Descripcion;
import com.example.george.lolapp.Modelo.Campeon.ListaCampeones;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Champs extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Descripcion> data;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champs);
        initViews();
        loadJSON();
    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
//        adapter = new DataAdapter();
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        loadJSON();
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ddragon.leagueoflegends.com/cdn/8.15.1/data/es_MX/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ManagerService service = retrofit.create(ManagerService.class);
        Call<ListaCampeones> campeones = service.getCampeones();
        campeones.enqueue(new Callback<ListaCampeones>() {
            @Override
            public void onResponse(Call<ListaCampeones> call, Response<ListaCampeones> response) {

                if (response.isSuccessful()){



                    Map<String, Descripcion> data = response.body().getData();

                    Log.e("TAG","campeones => " + data.size());

                    for (Map.Entry<String, Descripcion> entry : data.entrySet()){
//                        Log.d("TAG", "campeon => " + entry.getKey() + " / " + entry.getValue());

                       Log.e("TAG", entry.getValue().getInfo().getAttack() );
                       Log.e("TAG", entry.getValue().getName());
                       Log.e("TAG", entry.getValue().getTitle());
                        Log.e("TAG", entry.getValue().getBlurb());
                        Log.e("TAG", entry.getValue().getId());

                       //codo = data.get(nombreCampeon);




                    }



//                    ListaCampeones campeones = response.body();
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
            public void onFailure(Call<ListaCampeones> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
