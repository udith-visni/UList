package com.example.udt.ulist.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.udt.ulist.DB.DatabaseHandler;
import com.example.udt.ulist.R;
import com.example.udt.ulist.adapter.MainListAdapter;
import com.example.udt.ulist.model.MyLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UDT on 8/20/2017.
 */

public class ShoppingListFragment extends BaseFragment {
    View view;
    MainListAdapter mainListAdapter;
    private RecyclerView rvMainList;
    Dialog addMainItemDialog;
    List<MyLists> myLists;
    private static final String TAG = ShoppingListFragment.class.getSimpleName();
    private EditText etListName;
    public DatabaseHandler databaseHandler;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        initViews(view);
        setUpView();
        return view;
    }

    private void initViews(View view) {
        rvMainList = (RecyclerView) view.findViewById(R.id.rvMainList);

    }

    private void setUpView(){
        databaseHandler= new DatabaseHandler(getActivity());
        myLists = new ArrayList();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvMainList.setLayoutManager(mLayoutManager);
        rvMainList.setItemAnimator(new DefaultItemAnimator());
        if(databaseHandler.getListCount()>0){
            showLists();
        }
        initFab();
    }

    private void addLists(String listName){
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        databaseHandler.addList(new MyLists(listName));

        clearData();
        showLists();
    }

    public void clearData() {
        myLists.clear(); //clear list
        mainListAdapter.notifyDataSetChanged(); //let your adapter know about the changes and reload view.
    }

    public void showLists() {
        myLists.addAll(databaseHandler.getAlllists());
        mainListAdapter = new MainListAdapter(getActivity(), myLists);
        rvMainList.setAdapter(mainListAdapter);
        mainListAdapter.notifyDataSetChanged();
    }

    private void initFab(){
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                final View yourCustomView = inflater.inflate(R.layout.dialog_main_list, null);

                final TextView etName = (EditText) yourCustomView.findViewById(R.id.etListName);
                AlertDialog dialog = new AlertDialog.Builder(getActivity(),R.style.AlertDialogTheme)
                        .setTitle("          Enter Your MyLists Name")
                        .setView(yourCustomView)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String ListName = etName.getText().toString();

                                if (!ListName.isEmpty()) {
                                    addLists(ListName);
                                }

                                Log.d(TAG,"ListName "+ListName);
                            }
                        })
                        .setNegativeButton("Cancel", null).create();
                dialog.show();

            }
        });
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
