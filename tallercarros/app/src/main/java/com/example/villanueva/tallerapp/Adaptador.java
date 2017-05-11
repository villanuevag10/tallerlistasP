package com.example.villanueva.tallerapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Adaptador extends RecyclerView.Adapter<Adaptador.CarroViewHolder>{
    private ArrayList<Carro> carros;

    public Adaptador(ArrayList<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {
        Carro p = carros.get(position);

        holder.foto.setImageResource(p.getFoto());
        holder.cajaPlaca.setText(p.getPlaca());
        holder.cajaPrecio.setText(p.getPrecio()+"");
        holder.cajaMarca.setText(p.getMarca());
        holder.cajaModelo.setText(p.getModelo());

    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new CarroViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{

        private TextView marca;
        private TextView precio;
        private TextView placa;
        private ImageView foto;
        private TextView modelo;
        public CarroViewHolder(View itemView) {
            super(itemView);
            marca=(TextView)itemView.findViewById(R.id.lblMarca);

            precio=(TextView)itemView.findViewById(R.id.lblPrecio);

            placa=(TextView)itemView.findViewById(R.id.lblPlaca);

            foto=(ImageView)itemView.findViewById(R.id.foto);

            modelo=(TextView)itemView.findViewById(R.id.lblModelo);



        }
    }
}
