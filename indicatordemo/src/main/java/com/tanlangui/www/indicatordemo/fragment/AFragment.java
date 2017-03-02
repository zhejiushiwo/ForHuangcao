package com.tanlangui.www.indicatordemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.tanlangui.www.indicatordemo.R;
import com.tanlangui.www.indicatordemo.adapter.ZiYanFragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SHM on 2017/02/27.
 */
public class AFragment extends Fragment {

    private View rootView;

    @BindView(R.id.tab_zy)
    TabLayout tabZy;
    @BindView(R.id.vp_zy)
    ViewPager vpZY;


    public AFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_ziyan, container, false);

        ButterKnife.bind(this, rootView);

        ArrayList<Fragment> frags = new ArrayList<>();

        ZXFragment zxFragment = new ZXFragment();
        XSFragment xsFragment = new XSFragment();
        ZRFragment zrFragment = new ZRFragment();
        HTFragment htFragment = new HTFragment();


        frags.add(zxFragment);
        frags.add(xsFragment);
        frags.add(zrFragment);
        frags.add(htFragment);

        ZiYanFragmentPagerAdapter adapter = new ZiYanFragmentPagerAdapter(getChildFragmentManager(), frags);

        vpZY.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        vpZY.setAdapter(adapter);

        tabZy.setupWithViewPager(vpZY);

        vpZY.setOffscreenPageLimit(5);

        return rootView;
    }
}
