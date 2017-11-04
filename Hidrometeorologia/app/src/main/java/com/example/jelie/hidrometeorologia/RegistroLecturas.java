package com.example.jelie.hidrometeorologia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class RegistroLecturas extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_lecturas);

        initInstances();
    }

    private void initInstances() {
        toolbar = findViewById(R.id.toolbarRegistroLecturas);
        toolbar.setTitle(R.string.ingresar_lecturas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void enviarFechaHora(View view) {
        Intent intent = new Intent(this, RegistrarNivel.class);

        String[] lectura = getFechaHora();
        intent.putExtra("lectura", lectura);

        startActivityForResult(intent, 1);
    }

    public String[] getFechaHora() {
        String[] lecturas = new String[2];
        DatePicker dpFechaLectura = findViewById(R.id.dpFechaLectura);
        TimePicker tpHoraLectura = findViewById(R.id.tpHoraLectura);

        int day = dpFechaLectura.getDayOfMonth();
        int month = dpFechaLectura.getMonth() + 1;
        int year = dpFechaLectura.getYear();

        Log.i("Date Lectura", year+"-"+month+"-"+day);

        int hour = tpHoraLectura.getCurrentHour();
        int minute = tpHoraLectura.getCurrentMinute();

        Log.i("Time Lectura", hour+":"+minute);

        lecturas[0] = year+"-"+month+"-"+day;
        lecturas[1] = hour+":"+minute;

        return lecturas;
    }
}
