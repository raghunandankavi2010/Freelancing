package com.talkativeparents.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Raghunandan on 24-02-2016.
 */
public class DummyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView tv= new TextView(getActivity());
        tv.setGravity(Gravity.CENTER);
        tv.setText("Dummy Fragment");
        return tv;
    }
}
