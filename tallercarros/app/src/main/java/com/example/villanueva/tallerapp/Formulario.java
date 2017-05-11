package com.example.villanueva.tallerapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class Formulario extends AppCompatActivity {

    private EditText placa,precio;
    private Spinner marca, modelo, color;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        res= getResources();
        placa=(EditText)findViewById(R.id.placa);
        precio=(EditText)findViewById(R.id.precio);
        color=(Spinner)findViewById(R.id.spColor);
        marca=(Spinner)findViewById(R.id.spMarca);
        modelo=(Spinner)findViewById(R.id.spModelo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, res.getStringArray(R.array.listaColor));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, res.getStringArray(R.array.listaMarca));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marca.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, res.getStringArray(R.array.listaModelo));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelo.setAdapter(adapter3);


    }


    public void cancelar(View v){
        Intent i = new Intent(Formulario.this,Principal.class);
        startActivity(i);
    }
    public void guardar(View v){
            if(!placa.getText().toString().isEmpty()) {
                if(!precio.getText().toString().isEmpty()) {
                    String col = color.getSelectedItem().toString().trim();
                    double pre = Double.parseDouble(precio.getText().toString());

                    String pla = placa.getText().toString();
                    String mar = marca.getSelectedItem().toString().trim();
                    String mod = modelo.getSelectedItem().toString().trim();
                    Carro p = new Carro(foto_aleatoria(), mod, mar, pla,col,pre);
                    p.guardar(this);

                    cajaPrecio.setText("");

                    cajaPlaca.setText("");

                    Toast.makeText(Formulario.this,res.getString(R.string.alerta6), Toast.LENGTH_SHORT).show();
        }else{
                    precio.setError(res.getString(R.string.alerta5));
                    placa.setError(null);
        }
            }else{
                placa.setError(res.getString(R.string.alerta4));
                precio.setError(null);
            }
    }
    public int foto_aleatoria(){
        int fotos[]= {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int foto_seleccionada;
        Random r = new Random();
        foto_seleccionada=r.nextInt(3-0);
        return fotos[foto_seleccionada];
    }


    @Override
    public void onBackPressed(){
        Intent i = new Intent(Formulario.this,Principal.class);
        startActivity(i);
    }

}
