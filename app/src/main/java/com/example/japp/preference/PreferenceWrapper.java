package com.example.japp.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.japp.BuildConfig;

public class PreferenceWrapper {
    private static final String DEFAULT_PREF_NAME = BuildConfig.APPLICATION_ID + ".preferences";
    private final Context mContext;
    private SharedPreferences mPref;

    PreferenceWrapper(Context context) {
        mContext = context;
        mContext.getSharedPreferences(DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
    }

    public String getString(String key, String defaultValue) {
        return mPref.getString(key, defaultValue);
    }

    public void putString(String key, String defaultValue) {
        mPref.edit().putString(key, defaultValue).apply();
    }
}
