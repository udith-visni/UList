package com.example.udt.ulist;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.EditText;

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