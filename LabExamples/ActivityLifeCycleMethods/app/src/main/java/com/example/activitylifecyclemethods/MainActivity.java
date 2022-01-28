package com.example.activitylifecyclemethods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String TAG = "NeRo::Activity Lifecycle Methods Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: onStart method executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: onResume method executed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: onPause method executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: onStop method executed");
    }


}