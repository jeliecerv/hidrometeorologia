package com.example.jelie.hidrometeorologia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PagosFragment extends Fragment {


    private ListView listView;

    public PagosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pagos, container, false);

        listView = (ListView) view.findViewById(R.id.pagosList);
        
        return view;
    }

    public void listPagos() {
//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(this, R.layout.pagos_row, items);
//
//        listView.setAdapter(itemsAdapter);
    }

}
