package com.example.sergi.erasmusapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sergi on 09/01/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Movies", "Books", "Games"};
    private Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    /*This is supposed to work when notifyDataSetChanged called to update all 3 views*/
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void refresh(){
        notifyDataSetChanged();
    }

}