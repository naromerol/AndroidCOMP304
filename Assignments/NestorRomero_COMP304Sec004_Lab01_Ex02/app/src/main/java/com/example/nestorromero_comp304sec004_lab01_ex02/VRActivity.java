package com.example.nestorromero_comp304sec004_lab01_ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VRActivity extends AppCompatActivity {

    //View reference
    TextView vrActivityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vractivity);

        vrActivityTextView = findViewById(R.id.textview_vr_activity);
        vrActivityTextView.setText(vrActivityTextView.getText()+"\n onCreate Executed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        vrActivityTextView.setText(vrActivityTextView.getText()+"\n onStart Executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        vrActivityTextView.setText(vrActivityTextView.getText()+"\n onStop Executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vrActivityTextView.setText(vrActivityTextView.getText()+"\n onDestroy Executed");
    }
}