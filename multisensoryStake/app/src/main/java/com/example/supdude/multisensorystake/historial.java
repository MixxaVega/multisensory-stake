package com.example.supdude.multisensorystake;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class historial extends AppCompatActivity implements Serializable {

    ArrayList<Parcela> lista;
    ListView listview;
    Adaptador adaptador;

    AdminBD baseDatos = new AdminBD(this);

    int ultimo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        listview = findViewById(R.id.listview);
        lista = new ArrayList<Parcela>();

        try {
            leerArchivo();
        }catch (Exception e){
            Toast.makeText(this, "Esta es la exception del leer en el onCreate", Toast.LENGTH_SHORT).show();
        }

    }

    public void leerArchivo() {
        SQLiteDatabase base = baseDatos.getWritableDatabase();
        Cursor tabla = baseDatos.consultaTotal(base);
        try {
            int numregistro = tabla.getCount();
            tabla.moveToFirst();
            for (int i = 0; i < numregistro; i++){
                lista.add(new Parcela(tabla.getString(0), tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4), tabla.getString(5)));
                tabla.moveToNext();

                Collections.sort(lista, new Comparator<Parcela>() {
                    public int compare(Parcela obj1, Parcela obj2) {
                        return obj1.getId().compareToIgnoreCase(obj2.getId());
                    }
                });
                adaptador = new Adaptador(this, lista);
                listview.setAdapter(adaptador);
                ultimo = i;
            }

            adaptador.notifyDataSetChanged();
        }catch (Exception e){
        }

    }

}
