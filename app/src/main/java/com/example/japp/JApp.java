package com.example.japp;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class JApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
