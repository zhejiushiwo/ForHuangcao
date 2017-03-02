package com.tanlangui.www.indicatordemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by SHM on 2017/02/27.
 */
public class CFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(inflater.getContext());
        textView.setTextSize(24);
        textView.setGravity(Gravity.CENTER);
        textView.setText(getClass().getSimpleName());
        return textView;
    }
}
