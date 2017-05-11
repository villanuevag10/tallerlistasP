package com.example.villanueva.tallerapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {


    private RecyclerView listado;
    private Adaptador adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado=(RecyclerView)findViewById(R.id.lista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listado.setLayoutManager(llm);
        adapter = new Adaptador(inicializarDatos());
        listado.setAdapter(adapter);
    }

    public ArrayList<Carro> inicializarDatos(){
        ArrayList<Carro> personas = new ArrayList<>();
        String sql,placa,modelo,marca, color;
        SQLiteDatabase db;
        int foto;
        double precio;
        Carro p;
        CarroSQLite psoh = new CarroSQLite(this);
        db=psoh.getReadableDatabase();
        sql="Select * from Carros";
        Cursor c= db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getInt(0);
                modelo=c.getString(1);
                marca=c.getString(2);
                placa=c.getString(3);
                color=c.getString(4);
                precio=c.getDouble(5);
                p= new Carro(foto,modelo,marca,placa, color,precio);
                personas.add(p);
            }while(c.moveToNext());
        }
        return personas;
    }

}
