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
    HMoPagosAdapter dbHelper;

    public PagosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new HMoPagosAdapter(getActivity());
        dbHelper.open();
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
                new String[]{HMoPagosAdapter.KEY_MES, HMoPagosAdapter.KEY_DIASREPORTE, HMoPagosAdapter.KEY_VALORREPORTE,HMoPagosAdapter.KEY_TOTALPAGADO, HMoPagosAdapter.KEY_DEUDA},
                     new int[]{R.id.mes, R.id.diasreporte, R.id.valorreporte, R.id.totalpagado, R.id.deuda},0);
        listView.setAdapter(cursorAdapter);}


    public void listPagos() {
//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(this, R.layout.pagos_row, items);
//
//        listView.setAdapter(itemsAdapter);
    }

}
