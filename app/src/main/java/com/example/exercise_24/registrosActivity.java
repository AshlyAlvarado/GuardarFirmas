package com.example.exercise_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class registrosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private signaturess firmaAdapter;
    private List<byte[]> firmasList;
    private MyDatabaseHelper dbHelper;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        firmasList = obtenerFirmasDesdeBaseDeDatos();

        recyclerView = findViewById(R.id.recyclerViewRegistros);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firmaAdapter = new signaturess(firmasList);
        recyclerView.setAdapter(firmaAdapter);

        backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Vuelve a la actividad anterior al presionar el botón
            }
        });

    }
    private List<byte[]> obtenerFirmasDesdeBaseDeDatos() {
        dbHelper = new MyDatabaseHelper(this);
        return dbHelper.obtenerFirmasDesdeBaseDeDatos();
    }


}