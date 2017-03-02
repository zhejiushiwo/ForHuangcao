package com.tanlangui.www.indicatordemo.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by on 2017/3/1.
 * author: huangCao
 * QQ:1075269294
 * Email:hcwanhx@163.com
 */

public class ZiYanFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments;
    private String[] tabTitles = {"最新", "悬赏", "最热", "话题"};

    public ZiYanFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
////        return super.getPageTitle(position);
//        String ret = null;
//        switch (position) {
//            case 0:
//                ret = "最新";
//                break;
//            case 1:
//                ret = "悬赏";
//                break;
//            case 2:
//                ret = "最热";
//                break;
//            case 3:
//                ret = "话题";
//                break;
//        }
//        return ret;
    }

}

