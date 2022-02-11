package com.example.nestorromero_comp304sec004_lab01_ex02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

/**
 * COMP304 SEC004 - Assignment 1 - Exercise 2
 * Nestor Romero - 301133331
 */
public class MainActivity extends AppCompatActivity {

    MainActivityLifecycleFragment mainActivityLifecycleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityLifecycleFragment = (MainActivityLifecycleFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_main_activity_lifecycle);
        mainActivityLifecycleFragment.displayMessage("MainActivity onCreate executed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityLifecycleFragment.displayMessage("MainActivity onStart executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainActivityLifecycleFragment.displayMessage("MainActivity onStop executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainActivityLifecycleFragment.displayMessage("MainActivity onDestroy executed");
    }

}