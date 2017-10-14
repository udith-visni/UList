package com.example.udt.ulist.util;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private final static String TAG = MySharedPreferences.class.getSimpleName();

    // SharedPreference Keys
    public static final String PREFS_FILENAME = "ulist";
    public static final int PREFS_MODE = 0;
    public static final String PREFS_COLLEGE_DEFAULT_NAME = "defaultCollegeName";
    public static final String PREFS_LIST_NAMES = "defaultListName";



    private final SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context context;

    public MySharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFS_FILENAME,
                PREFS_MODE);
        mEditor = mSharedPreferences.edit();
        this.context = context;
    }

    public void clearUserPrefs() {
        mEditor.clear();
        mEditor.apply();
    }

    public void saveUserCollegName(String name) {
        mEditor.putString(PREFS_COLLEGE_DEFAULT_NAME, name);
        mEditor.apply();
    }

    public String getUserCollegeName() {
        if (mSharedPreferences.getString(PREFS_COLLEGE_DEFAULT_NAME, "") != null)
            return mSharedPreferences.getString(PREFS_COLLEGE_DEFAULT_NAME, "");
        else
            return "";
    }


}