package com.example.jelie.hidrometeorologia;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by jelie on 7/11/2017.
 */

public class MySimpleCursorAdapter extends SimpleCursorAdapter {


    public MySimpleCursorAdapter(FragmentActivity activity, int lecturas_row, Cursor lecturas, String[] strings, int[] ints, int i) {
        super(activity, lecturas_row, lecturas, strings, ints, i);
    }

    @Override
    public void setViewText(TextView v, String text){
        if(v.getId() == R.id.fecha){
            text = getDate(Double.parseDouble(text), "dd MMMM yyyy HH:mm");
        }

        v.setText(text);

    }


    public String getDate(double miliSeconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(miliSeconds);
    }
}
