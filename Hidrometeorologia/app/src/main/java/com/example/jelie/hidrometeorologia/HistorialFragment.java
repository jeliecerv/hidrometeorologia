package com.example.jelie.hidrometeorologia;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistorialFragment extends Fragment {

    private ListView listView;
    Cursor lecturas;

    HMoDbAdapter dbHelper;

    public HistorialFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new HMoDbAdapter(getActivity());
        dbHelper.open();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historial, container, false) ;
        listView = view.findViewById(R.id.historialList);
        refresh();

        return view;
    }


    private void refresh() {
        lecturas = dbHelper.fetchAllLecturas();
        lecturas.moveToFirst();
        MySimpleCursorAdapter cursorAdapter = new MySimpleCursorAdapter(getActivity(),
                R.layout.lecturas_row,
                lecturas,
                new String[]{HMoDbAdapter.KEY_FECHA, HMoDbAdapter.KEY_VALOR},
                new int[]{R.id.fecha, R.id.valor},
                0);
        listView.setAdapter(cursorAdapter);

    }

}
