package com.example.udt.ulist.activities;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.udt.ulist.R;
import com.example.udt.ulist.util.Constant;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by UDT on 10/15/2017.
 */

public class BaseActivity extends AppCompatActivity {


    private static final String TAG = BaseActivity.class.getSimpleName();
    protected SharedPreferences sharedPreferences;
    protected SharedPreferences.Editor sharedEditor;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        sharedPreferences = getSharedPreferences(Constant.ULIST_SHARED_PREF, MODE_PRIVATE);
        sharedEditor = sharedPreferences.edit();
    }


}
