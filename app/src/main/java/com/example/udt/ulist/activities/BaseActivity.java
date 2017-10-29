package com.example.udt.ulist.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;
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
    private static ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        sharedPreferences = getSharedPreferences(Constant.ULIST_SHARED_PREF, MODE_PRIVATE);
        sharedEditor = sharedPreferences.edit();
    }


    @UiThread
    protected void initProgressBar() {
        progressDialog = new ProgressDialog(this, R.style.MyProgressTheme);
        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Loading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
    }

    @UiThread
    protected void startProgressBar() {
        try {
            if (progressDialog != null) {
                progressDialog.show();
            }
        } catch (Exception ex) {
            Log.d(TAG, "startProgressBar : Exception = " + ex);
        }
    }

    @UiThread
    protected void stopProgressBar() {
        if (progressDialog != null) {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }


    protected boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }


    @UiThread
    public void showSnackbar(View view, String message, String status) {
        showToast(view, message, status);
    }


    public void showToast(View view, String message, String status) {

        TSnackbar snackbar = TSnackbar
                .make(view, " " + message, TSnackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.WHITE);
        snackbar.setIconLeft(getIcon(status), 15);
        snackbar.setIconPadding(5);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(getBackgroundColor(status));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    private int getBackgroundColor(String status) {

        int color = Color.parseColor("#dd3c40");

        switch (status) {
            case "success":
                color = Color.parseColor("#76CF67");
                break;

            case "failed":
                color = Color.parseColor("#dd3c40");
                break;

            case "error":
                color = Color.parseColor("#dd3c40");
                break;
        }

        return color;
    }

    private int getIcon(String status) {

        int icon = R.drawable.ic_close_white_error;

        switch (status) {
            case "success":
                icon = R.drawable.ic_success;
                break;

            case "failed":
                icon = R.drawable.ic_close_white_error;
                break;

            case "error":
                icon = R.drawable.ic_close_white_error;
                break;
        }
        return icon;
    }


}
