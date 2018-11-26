package com.example.administrator.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TGA="TTT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Log.i(TGA,"------>onCreate");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TGA,"------>onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TGA,"------>onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TGA,"------>onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TGA,"------>onDestroy");

    }
}
