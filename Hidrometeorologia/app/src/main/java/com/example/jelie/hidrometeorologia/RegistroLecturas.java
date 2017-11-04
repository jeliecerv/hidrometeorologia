package com.example.jelie.hidrometeorologia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.DatePicker;

public class RegistroLecturas extends AppCompatActivity {

    private Toolbar toolbar;
    private DatePicker dpFechaLectura;

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

        dpFechaLectura = findViewById(R.id.dpFechaLectura);
//        dpFechaLectura.setCalendarViewShown(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
