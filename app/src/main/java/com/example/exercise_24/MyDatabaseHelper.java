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

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Define la sentencia SQL para crear la tabla
        String createTableQuery = "CREATE TABLE mi_basededatos(_id INTEGER PRIMARY KEY AUTOINCREMENT, signature BLOB, nombre TEXT)";

        // Ejecuta la sentencia SQL para crear la tabla
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si necesitas realizar alguna actualización en la estructura de la base de datos, puedes implementarla aquí
    }

    public List<byte[]> obtenerFirmasDesdeBaseDeDatos() {
        List<byte[]> firmasList = new ArrayList<>();

        // Obtén una instancia de lectura de la base de datos
        SQLiteDatabase db = getReadableDatabase();

        // Define las columnas que deseas seleccionar
        String[] columnas = {"signature, nombre"};

        // Realiza la consulta SELECT
        Cursor cursor = db.query("mi_basededatos", columnas, null, null, null, null, null);

        // Itera a través del cursor para obtener los datos de las firmas
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int columnIndex = cursor.getColumnIndex("signature");
                if (columnIndex != -1) {
                    byte[] firma = cursor.getBlob(columnIndex);
                    firmasList.add(firma);
                }

                String[] columnNames = cursor.getColumnNames();

// Imprime los nombres de las columnas en el Logcat
                for (String columnName : columnNames) {
                    Log.d("Columnas", columnName);
                }
            } while (cursor.moveToNext());
        }

        // Cierra el cursor y la base de datos
        cursor.close();
        db.close();

        return firmasList;
    }

}