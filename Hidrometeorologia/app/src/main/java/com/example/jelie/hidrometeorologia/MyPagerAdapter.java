package com.example.jelie.hidrometeorologia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by s105e6 on 1/11/2017.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    PagosFragment pagosFragment;
    HistorialFragment historialFragment;

    public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if(pagosFragment==null){
                    pagosFragment = new PagosFragment();
                }
                return  pagosFragment;
            case 1:
                if(historialFragment==null){
                    historialFragment = new HistorialFragment();
                }
                return historialFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Pagos";
        }else if(position==1){
            return "Historial";
        }
        return "";
    }
}