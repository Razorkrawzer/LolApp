package com.example.george.lolapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.george.lolapp.Modelo.Campeones.Campeones;
import com.example.george.lolapp.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Campeones> champs;

    public DataAdapter(ArrayList<Campeones> champs){
        this.champs = champs;
    }



    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.titulo.setText(champs.get(i).getTitle());
        viewHolder.identificador.setText(champs.get(i).getId());
        viewHolder.nombre.setText(champs.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return champs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, identificador, nombre;

        public ViewHolder(View view){
            super(view);

            titulo = (TextView)view.findViewById(R.id.titulo);
            identificador = (TextView)view.findViewById(R.id.identificador);
            nombre = (TextView)view.findViewById(R.id.nombre);



        }
    }

}
