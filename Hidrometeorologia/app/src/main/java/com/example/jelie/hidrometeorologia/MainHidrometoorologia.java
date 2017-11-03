package com.example.jelie.hidrometeorologia;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainHidrometoorologia extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hidrometoorologia);

        initInstances();
    }

    private void initInstances() {
        toolbar = findViewById(R.id.toolbarMain);
        toolbar.setTitle(R.string.hidrometeorologia);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);

        ViewPager mViewPager = findViewById(R.id.viewPager);
        MyPagerAdapter mViewPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
