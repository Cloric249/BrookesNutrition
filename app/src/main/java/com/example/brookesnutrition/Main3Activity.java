package com.example.brookesnutrition;

import android.net.Uri;
import android.os.Bundle;

import com.example.brookesnutrition.ui.main.frag1;
import com.example.brookesnutrition.ui.main.frag2;
import com.example.brookesnutrition.ui.main.frag3;
import com.example.brookesnutrition.ui.main.frag4;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.brookesnutrition.ui.main.SectionsPagerAdapter;

public class Main3Activity extends AppCompatActivity implements frag1.OnFragmentInteractionListener, frag2.OnFragmentInteractionListener, frag3.OnFragmentInteractionListener, frag4.OnFragmentInteractionListener {


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
}