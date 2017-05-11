package com.example.reyes.tallerapp;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte3 extends AppCompatActivity {

    private TextView Carros;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte3);
        res = getResources();
        Carros = (TextView)findViewById(R.id.ncolor);


        Carros.setText(inicializarDatos() + "");
    }

    public String inicializarDatos(){
        ArrayList<Carro> personas = new ArrayList<>();
        Carro p;
        SQLiteDatabase db;
        String sql,placa,modelo,marca, color, resultado="No hay Vehiculos Registrados";
        int foto;
        double precio;
        CarroSQLite psoh = new CarroSQLite(this);
        db=psoh.getReadableDatabase();
        int rosado =0;
        int piel = 0;
        int negro = 0;

        sql="Select * from Carros";
        Cursor c= db.rawQuery(sql, null);

        if(c.moveToFirst()){
            do{
                foto = c.getInt(0);
                modelo=c.getString(1);
                marca=c.getString(2);
                placa=c.getString(3);
                color=c.getString(4);
                precio=c.getDouble(5);
                p= new Carro(foto,modelo,marca,placa, color,precio);
                if(color.equalsIgnoreCase("rosado") || color.equalsIgnoreCase("pink")){
                    rosado = rosado+1;
                }
                if(color.equalsIgnoreCase( "Negro") || color.equalsIgnoreCase("Black")){
                    negro = negro+1;
                }
                if(color.equalsIgnoreCase("violeta") || color.equalsIgnoreCase( "violet")){
                    violeta = violeta+1;
                }
                personas.add(p);
            }while(c.moveToNext());
        }
        resultado = "Carros rosados = "+rosados +"\n"+"Carros violetas = "+violetas +"\n"+"Carros Negros = "+negro +"\n";
        return resultado;
    }
}
