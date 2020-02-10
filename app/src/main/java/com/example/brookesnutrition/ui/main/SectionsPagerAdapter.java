package com.example.brookesnutrition.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.brookesnutrition.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
<<<<<<< HEAD
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
=======
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
>>>>>>> Initial commit
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = frag1.newInstance();
                break;
            case 1:
                fragment = frag2.newInstance();
                break;
            case 2:
                fragment = frag3.newInstance();
                break;
<<<<<<< HEAD
            case 3:
                fragment = frag4.newInstance();
                break;
=======
>>>>>>> Initial commit
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
<<<<<<< HEAD
        // Show 4 total pages.
        return 4;
=======
        // Show 2 total pages.
        return 3;
>>>>>>> Initial commit
    }
}