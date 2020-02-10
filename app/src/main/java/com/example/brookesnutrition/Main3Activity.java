package com.example.brookesnutrition;

<<<<<<< HEAD
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
=======
import android.net.Uri;
import android.os.Bundle;
>>>>>>> Initial commit

import com.example.brookesnutrition.ui.main.frag1;
import com.example.brookesnutrition.ui.main.frag2;
import com.example.brookesnutrition.ui.main.frag3;
<<<<<<< HEAD
import com.example.brookesnutrition.ui.main.frag4;;
=======
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
>>>>>>> Initial commit
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD


import com.example.brookesnutrition.ui.main.SectionsPagerAdapter;

import java.util.Calendar;

public class Main3Activity extends AppCompatActivity implements frag1.OnFragmentInteractionListener, frag2.OnFragmentInteractionListener, frag3.OnFragmentInteractionListener, frag4.OnFragmentInteractionListener {
=======
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.brookesnutrition.ui.main.SectionsPagerAdapter;

public class Main3Activity extends AppCompatActivity implements frag1.OnFragmentInteractionListener, frag2.OnFragmentInteractionListener, frag3.OnFragmentInteractionListener {
>>>>>>> Initial commit


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main3);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
<<<<<<< HEAD



=======
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
>>>>>>> Initial commit
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}