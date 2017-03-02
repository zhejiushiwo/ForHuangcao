package com.tanlangui.www.indicatordemo;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.tanlangui.www.indicatordemo.adapter.SampleFragmentPagerAdapter;
import com.tanlangui.www.indicatordemo.fragment.AFragment;
import com.tanlangui.www.indicatordemo.fragment.BFragment;
import com.tanlangui.www.indicatordemo.fragment.CFragment;
import com.tanlangui.www.indicatordemo.fragment.DFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity implements View.OnSystemUiVisibilityChangeListener {

    private static final String TAG = "MainActivity";
    @BindView(R.id.tab_main)
    TabLayout tabMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.fl_btn_back)
    FrameLayout flBtnBack;
    @BindView(R.id.fl_btn_search)
    FrameLayout flBtnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        requestWindowFeature(Window.FEATURE_ACTION_MODE_OVERLAY);
        setStatusBarTransparent();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initListener();
        initData();
    }

    private void initView() {
        ArrayList<Fragment> frags = new ArrayList<>();
        AFragment aFragment = new AFragment();
        BFragment bFragment = new BFragment();
        CFragment cFragment = new CFragment();
        DFragment dFragment = new DFragment();
        frags.add(aFragment);
        frags.add(bFragment);
        frags.add(cFragment);
        frags.add(dFragment);
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        SampleFragmentPagerAdapter pagerAdapter =
                new SampleFragmentPagerAdapter(getSupportFragmentManager(), frags);
        vpMain.setAdapter(pagerAdapter);
        tabMain.setupWithViewPager(vpMain);
    }

    private void initListener() {
        tabMain.addOnTabSelectedListener(new MyOnTabSelectedListener());
    }

    private void initData() {

    }

    /**
     * 设置浸入式状态栏
     */
    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //托盘重叠显示在Activity上
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(uiOptions);
            decorView.setOnSystemUiVisibilityChangeListener(this);
            // 设置托盘透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //Log.d("CP_Common","VERSION.SDK_INT =" + VERSION.SDK_INT);
        } else {
            //Log.d("CP_Common", "SDK 小于19不设置状态栏透明效果");
        }
    }

    @Override
    public void onSystemUiVisibilityChange(int visibility) {

    }

    @OnClick({R.id.fl_btn_back, R.id.fl_btn_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fl_btn_back:
                Toast.makeText(this, "返回退出", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_btn_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private class MyOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Log.e(TAG, "onTabSelected: pos--> " + tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            Log.e(TAG, "onTabUnselected: pos--> " + tab.getPosition());
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            Log.e(TAG, "onTabReselected: pos--> " + tab.getPosition());
        }
    }
}
