package com.example.udt.ulist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.udt.ulist.fragments.ShoppingListFragment;
import com.example.udt.ulist.model.MainListItem;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.fragment;
import static android.R.attr.value;
import static android.R.id.list;

/**
 * Created by UDT on 9/23/2017.
 */


public class CustomDialog extends AlertDialog {

    private static final String TAG = CustomDialog.class.getSimpleName();
    private EditText etListName;


    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_main_list);
        etListName=(EditText)findViewById(R.id.etListName);
    }


}