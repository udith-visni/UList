package com.example.udt.ulist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.udt.ulist.R;

import java.util.zip.Inflater;

/**
 * Created by UDT on 10/15/2017.
 */

public class BaseFragment extends Fragment {
private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_base,container,false);
        return view;
    }
}
