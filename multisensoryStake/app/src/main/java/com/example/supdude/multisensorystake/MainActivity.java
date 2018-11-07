package com.example.supdude.multisensorystake;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button btnInfo;
    Button btnDatos;
    Button btnHistorial;
    ImageView btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInfo = findViewById(R.id.btnInformacion);
        btnDatos = findViewById(R.id.btnDatos);
        btnHistorial = findViewById(R.id.btnHistorial);
        btnBlue = findViewById(R.id.btnBlue);

        btnInfo.setOnClickListener(this);
        btnDatos.setOnClickListener(this);
        btnHistorial.setOnClickListener(this);
        btnBlue.setOnClickListener(this);

        AdminBD baseDatos = new AdminBD(this);
        SQLiteDatabase base = baseDatos.getWritableDatabase();
        //insertar en la base de datos
        baseDatos.insertarRegistro(base);

        Cursor tabla = baseDatos.consultaTotal(base);

        int numregistro = tabla.getCount();
        Toast.makeText(this, String.valueOf(numregistro), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnInformacion:
               // Intent i = new Intent(this, informacion.class);
               // startActivity(i);
                break;
            case R.id.btnDatos:
                 Intent i = new Intent(this, datos.class);
                 startActivity(i);
                break;
            case R.id.btnHistorial:
                 i = new Intent(this, historial.class);
                 startActivity(i);
                break;
            case R.id.btnBlue:
                break;
        }

    }
}
