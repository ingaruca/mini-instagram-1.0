package com.example.aaron.mini_instagram.OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite_OpenHelper extends SQLiteOpenHelper {


    public Sqlite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table usuario(_Id Integer primary key autoincrement,Correo text,Contraseña1 text,Contraseña2 text);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrir()
    {
        this.getWritableDatabase();
    }

    public void cerrar()
    {
        this.close();
    }

    public void insertarRegistro(String Correo,String Contraseña1,String Contraseña2)
    {
        ContentValues datosingresados = new ContentValues();
        datosingresados.put("Correo",Correo);
        datosingresados.put("Contraseña1",Contraseña1);
        datosingresados.put("Contraseña2",Contraseña2);
        this.getWritableDatabase().insert("usuario",null,datosingresados);
    }




}
