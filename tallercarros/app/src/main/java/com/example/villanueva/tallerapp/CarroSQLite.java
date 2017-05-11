package com.example.villanueva.tallerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarroSQLite extends SQLiteOpenHelper {
    private String sql= "create table Carros(modelo text,marca text,placa text,color text,precio text,foto text)";
    private static final int VERSION_BASE_DE_DATOS =1;
    private static final String NOMBRE_BASE_DE_DATOS ="carros.db";
    public CarroSQLite(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Carros");
        db.execSQL(sql);
    }
}
