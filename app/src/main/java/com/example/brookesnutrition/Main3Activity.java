package com.example.brookesnutrition;
import android.net.Uri;
import android.os.Bundle;
import com.example.brookesnutrition.ui.main.frag1;
import com.example.brookesnutrition.ui.main.frag2;
import com.example.brookesnutrition.ui.main.frag3;
import com.example.brookesnutrition.ui.main.frag4;;
import com.example.brookesnutrition.ui.main.sendData;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;



import com.example.brookesnutrition.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;


public class Main3Activity extends AppCompatActivity implements frag1.OnFragmentInteractionListener, frag2.OnFragmentInteractionListener, frag3.OnFragmentInteractionListener, frag4.OnFragmentInteractionListener, sendData {

    private ArrayList<String> x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main3);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public ArrayList<String> getArrayList() {
        return x;
    }

    @Override
    public void setArrayList(ArrayList x) {
        this.x = x;
    }
}