package com.example.jelie.hidrometeorologia;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PagosFragment extends Fragment {


    private ListView listView;

    Cursor pagos;
    HMoDbAdapter dbHelper;

    public PagosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new HMoDbAdapter(getActivity());
        dbHelper.open();

        populatePagos();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pagos, container, false);
        listView = (ListView) view.findViewById(R.id.pagosList);
        refresh();
        return view;
    }

    private void refresh() {
        pagos = dbHelper.fetchAllPagos();
        pagos.moveToFirst();
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(getActivity(),
                R.layout.pagos_row,
                pagos,
                new String[]{
                        HMoDbAdapter.KEY_MES,
                        HMoDbAdapter.KEY_DIASREPORTE,
                        HMoDbAdapter.KEY_VALORREPORTE,
                        HMoDbAdapter.KEY_TOTALPAGADO,
                        HMoDbAdapter.KEY_DEUDA
                },
                 new int[]{R.id.mes, R.id.diasreporte, R.id.valorreporte, R.id.totalpagado, R.id.deuda},0);
        listView.setAdapter(cursorAdapter);
    }

    private void populatePagos() {
        dbHelper.open();
        dbHelper.createPago("Enero", "2", "50000", "5000", "45000");
        dbHelper.createPago("Febrero", "3", "60000", "6000", "54000");
        dbHelper.createPago("Marzo", "4", "70000", "7000", "63000");
        dbHelper.createPago("Abril", "5", "80000", "8000", "72000");
    }

}
