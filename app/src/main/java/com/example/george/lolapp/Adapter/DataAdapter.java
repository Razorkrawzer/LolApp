package com.example.george.lolapp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.george.lolapp.Modelo.Campeon.Descripcion;
import com.example.george.lolapp.Modelo.Campeon.JsonDataChamps;
import com.example.george.lolapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Map<String, Descripcion> listaCampeones;
    private ArrayList<String> llaves = new ArrayList<>();

    public DataAdapter(Map<String, Descripcion> listaCampeones) {
        this.listaCampeones = listaCampeones;
        for (Map.Entry<String, Descripcion> campeon : listaCampeones.entrySet()){
             String key = campeon.getKey();
            llaves.add(key);
        }
    }


    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) { ;
        Descripcion descripcionChamp = listaCampeones.get(llaves.get(i));
        viewHolder.nombre.setText(descripcionChamp.getName());
        viewHolder.titulo.setText(descripcionChamp.getTitle());
        viewHolder.blurb.setText(descripcionChamp.getBlurb());
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/8.16.1/img/champion/"+descripcionChamp.getImage().getFull()).into(viewHolder.imagen);


        //"http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/"+descripcionChamp.getImage().full();

    }

    @Override
    public int getItemCount() {
        return llaves.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, blurb, nombre;
        private ImageView imagen;

        public ViewHolder(View view){
            super(view);

            titulo = (TextView)view.findViewById(R.id.titulo);
            blurb = (TextView)view.findViewById(R.id.blurb);
            nombre = (TextView)view.findViewById(R.id.nombre);
            imagen = (ImageView)view.findViewById(R.id.icono);



        }
    }

}
