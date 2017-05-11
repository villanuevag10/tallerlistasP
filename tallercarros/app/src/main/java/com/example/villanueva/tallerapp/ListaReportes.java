package com.example.villanueva.tallerapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaReportes extends AppCompatActivity {
    ListView reporte;
    Resources res;
    String[] listaOpc;
    @Override
    ArrayAdapter<String> adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reportes);
        reporte = (ListView)findViewById(R.id.reportes);
        res = getResources();
        listaOpc = res.getStringArray(R.array.reportes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaOpc);
        reporte.setAdapter(adapter);
        reporte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        i = new Intent(ListaReportes.this, Reporte1.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(ListaReportes.this, Reporte2.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(ListaReportes.this, Reporte3.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(ListaReportes.this, Reporte4.class);
                        startActivity(i);
                        break;
                    case 4:
                        i = new Intent(ListaReportes.this, Reporte5.class);
                        startActivity(i);
                        break;
                    case 5:
                        i = new Intent(ListaReportes.this, Reporte6.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
