package com.example.exercise_24;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mi_basededatos.db";
    private static final int DATABASE_VERSION = 1;
    public static  final String tableName = "firmas";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String SelectTable= "SELECT * FROM " + tableName;
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Define la sentencia SQL para crear la tabla
        String createTableQuery = "CREATE TABLE firmas(id INTEGER PRIMARY KEY AUTOINCREMENT, signature BLOB, nombre TEXT)";

        // Ejecuta la sentencia SQL para crear la tabla
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si necesitas realizar alguna actualización en la estructura de la base de datos, puedes implementarla aquí
    }

}