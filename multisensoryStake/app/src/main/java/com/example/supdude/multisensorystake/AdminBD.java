package com.example.supdude.multisensorystake;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminBD extends SQLiteOpenHelper {

    final static String NOMBREBD = "bdmultisensor.db";
    final static Integer VERSIONBBD = 1;
    final static String NOMBRETABLA = "tblDatos";
    final static String NOMBRECAMPOID = "id";
    final static String NOMBRECAMPOPH = "nivelph";
    final static String NOMBRECAMPOSALINIDAD = "salinidad";
    final static String NOMBRECAMPOTEMPERATURA = "temperatura";
    final static String NOMBRECAMPOHUMEDAD = "humedad";
    final static String NOMBRECAMPOPARCELA = "parcela";
    final static String CREARTABLA = "CREATE TABLE "+NOMBRETABLA+" ("+NOMBRECAMPOID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +NOMBRECAMPOPH+" TEXT,"+NOMBRECAMPOSALINIDAD+" TEXT,"+NOMBRECAMPOTEMPERATURA+" TEXT,"+NOMBRECAMPOHUMEDAD+" TEXT,"+NOMBRECAMPOPARCELA+" TEXT);";
    final static String CONSULTASQL = "SELECT * FROM "+NOMBRETABLA+";";

    public AdminBD(Context context) {
        super(context, NOMBREBD, null, VERSIONBBD);

    }

    @Override
    public void onCreate(SQLiteDatabase bd) {

        bd.execSQL(CREARTABLA);

    }

    public void insertarRegistro(SQLiteDatabase bd){
        final String insertar = "insert into "+NOMBRETABLA+"("+NOMBRECAMPOPH+","+NOMBRECAMPOSALINIDAD+","+NOMBRECAMPOTEMPERATURA+","+NOMBRECAMPOHUMEDAD+"," +
                ""+NOMBRECAMPOPARCELA+") values('cosa1', 'cosa2', 'cosa3', 'cosa4', 'cosa5');";
        bd.execSQL(insertar);
    }

    public Cursor consultaTotal(SQLiteDatabase bd){

        Cursor t = bd.rawQuery(CONSULTASQL, null);
        return t;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
