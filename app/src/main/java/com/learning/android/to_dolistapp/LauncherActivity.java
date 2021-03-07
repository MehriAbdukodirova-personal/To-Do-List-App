package com.learning.android.to_dolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

public class LauncherActivity extends AppCompatActivity {
    String preferences_name = "isFirstTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        firstTime();
    }

    public  void  firstTime(){

        SharedPreferences sharedTime = getSharedPreferences(preferences_name,0);
        if (sharedTime.getBoolean("firstTime",true))
        {

            //When the app is launching for the first time
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(LauncherActivity.this, IntroductionActivity.class));
                    finish();
                }
            }, 4000);

            sharedTime.edit().putBoolean("firstTime",false).apply();
        }
        else
        {
            //When the app is NOT launching for the first time
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                    finish();
                }
            }, 4000);

        }
}}