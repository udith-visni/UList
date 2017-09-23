package com.example.udt.ulist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.udt.ulist.R;
import com.example.udt.ulist.adapter.MainListAdapter;
import com.example.udt.ulist.model.MainListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UDT on 8/20/2017.
 */

public class ShoppingListFragment extends android.support.v4.app.Fragment {
    View view;
    MainListAdapter mainListAdapter;
    private RecyclerView rvMainList;
    List<MainListItem> mainLists;
    private static final String TAG = ShoppingListFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        initViews(view);
        mainLists = new ArrayList();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvMainList.setLayoutManager(mLayoutManager);
        rvMainList.setItemAnimator(new DefaultItemAnimator());
        addItem();
        return view;
    }

    private void initViews(View view) {
        rvMainList = (RecyclerView) view.findViewById(R.id.rvMainList);
    }

    private void addItem() {
        mainLists.add(new MainListItem("My List 1","4","20"));
        mainLists.add(new MainListItem("My List 3","4","20"));
        mainLists.add(new MainListItem("My List 4","4","20"));
        mainLists.add(new MainListItem("My List 4","4","20"));
        mainLists.add(new MainListItem("My List 4","4","20"));
        mainLists.add(new MainListItem("My List 4","4","20"));
        mainLists.add(new MainListItem("My List 4","4","20"));
        mainListAdapter = new MainListAdapter(getActivity(), mainLists);
        rvMainList.setAdapter(mainListAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
