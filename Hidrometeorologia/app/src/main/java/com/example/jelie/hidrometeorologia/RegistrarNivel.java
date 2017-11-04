package com.example.jelie.hidrometeorologia;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class RegistrarNivel extends AppCompatActivity {

    private Toolbar toolbar;
    private String fecha;
    private String hora;
    private String nivel;
    private String observaciones;
    public static final String VARIABLE_NIVEL = "nivel";

    HMoDbAdapter dbHelper;
    Cursor lecturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_nivel);

        initInstances();
        getLectureFechaHora();

        dbHelper = new HMoDbAdapter(this);
        dbHelper.open();
    }

    private void initInstances() {
        toolbar = findViewById(R.id.toolbarRegistroLecturasNivel);
        toolbar.setTitle(R.string.ingresar_lecturas);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}

    public void getLectureFechaHora() {
        Intent intent = getIntent();
        String[] lectura = intent.getStringArrayExtra("lectura");

        fecha = lectura[0];
        hora = lectura[1];

        Log.i("lectura", lectura[0] +"-----"+lectura[1]);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void enviarNivel(View view) {
        getNivel();

        dbHelper.open();
        dbHelper.createLectura(fecha, hora, VARIABLE_NIVEL, nivel, observaciones);

        lecturas = dbHelper.fetchAllLecturas();
        lecturas.moveToFirst();

        try {
            while (lecturas.moveToNext()) {
                Log.i(lecturas.getColumnName(0), String.valueOf(lecturas.getInt(lecturas.getColumnIndexOrThrow(HMoDbAdapter.KEY_ROWID))));
                Log.i(lecturas.getColumnName(1), lecturas.getString(lecturas.getColumnIndexOrThrow(HMoDbAdapter.KEY_FECHA)));
                Log.i(lecturas.getColumnName(1), lecturas.getString(lecturas.getColumnIndexOrThrow(HMoDbAdapter.KEY_HORA)));
                Log.i(lecturas.getColumnName(1), lecturas.getString(lecturas.getColumnIndexOrThrow(HMoDbAdapter.KEY_VARIABLE)));
                Log.i(lecturas.getColumnName(1), lecturas.getString(lecturas.getColumnIndexOrThrow(HMoDbAdapter.KEY_VALOR)));
                Log.i(lecturas.getColumnName(1), lecturas.getString(lecturas.getColumnIndexOrThrow(HMoDbAdapter.KEY_OBSERVACIONES)));
            }
        } finally {
            lecturas.close();
        }

    }

    private void getNivel(){
          nivel = ((EditText)findViewById(R.id.nivel)).getText().toString();
          observaciones = ((EditText) findViewById(R.id.observaciones)).getText().toString();
    }
}
