package com.tanlangui.www.indicatordemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by SHM on 2017/02/27.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> mFrags;
    private String[] tabTitles = {"咨研社", "文库", "信披检索", "公告法规"};

    public SampleFragmentPagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> frags) {
        super(supportFragmentManager);
        this.mFrags = frags;
    }

    @Override
    public Fragment getItem(int position) {
        return mFrags.get(position);
    }

    @Override
    public int getCount() {
        return mFrags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
