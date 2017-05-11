package com.example.villanueva.tallerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Carro {
    int foto;
    String Modelo;
    String Placa;

    String Marca;
    double Precio;
    String Color;

    public Carro(int foto, String modelo, String marca, String placa, String color, double precio) {
        this.foto = foto;
        Modelo = modelo;
        Placa = placa;
        Marca = marca;
        Precio = precio;
        Color = color;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public double getPrecio() {
        return Precio;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }
    public void guardar(Context contexto){

        SQLiteDatabase db;
        String sql;

        CarroSQLite psoh = new CarroSQLite(contexto);
        db=psoh.getWritableDatabase();
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("foto",this.foto);
        nuevoRegistro.put("modelo",this.Modelo);
        nuevoRegistro.put("marca",this.Marca);

        nuevoRegistro.put("placa",this.Placa);

        nuevoRegistro.put("color",this.Color);

        nuevoRegistro.put("precio",this.Precio);
        db.insert("Carros",null,nuevoRegistro);


        db.close();
    }


}
