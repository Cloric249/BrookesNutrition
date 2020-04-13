package com.example.brookesnutrition;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import com.example.brookesnutrition.ui.main.frag1;
import com.example.brookesnutrition.ui.main.frag2;
import com.example.brookesnutrition.ui.main.frag3;
import com.example.brookesnutrition.ui.main.frag4;;
import com.example.brookesnutrition.ui.main.sendData;
import com.google.android.material.tabs.TabLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;



import com.example.brookesnutrition.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;


public class Main3Activity extends AppCompatActivity implements frag1.OnFragmentInteractionListener, frag2.OnFragmentInteractionListener, frag3.OnFragmentInteractionListener, frag4.OnFragmentInteractionListener, sendData {

    private ArrayList<String> x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int[] ICONS = new int[]{
                R.drawable.allergy,
                R.drawable.ic_action_name,
                R.drawable.gym,
                R.drawable.fruits};




        setContentView(R.layout.activity_main3);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setIcon(ICONS[0]);
        tabs.getTabAt(1).setIcon(ICONS[1]);
        tabs.getTabAt(2).setIcon(ICONS[2]);
        tabs.getTabAt(3).setIcon(ICONS[3]);



        AnimationDrawable animation = (AnimationDrawable) viewPager.getBackground();
        animation.setEnterFadeDuration(1500);
        animation.setExitFadeDuration(3000);
        animation.start();

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