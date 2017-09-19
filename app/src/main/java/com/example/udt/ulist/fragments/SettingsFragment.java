package com.example.udt.ulist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.udt.ulist.R;

/**
 * Created by UDT on 8/20/2017.
 */

public class SettingsFragment extends android.support.v4.app.Fragment {
    View myview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.fragment_settings,container,false);
        return myview;
    }
}
