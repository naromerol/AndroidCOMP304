package com.example.nestorromero_comp304sec004_lab01_ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AIActivity extends AppCompatActivity {

    //View reference
    TextView aiActivityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiactivity);

        aiActivityTextView = findViewById(R.id.textview_ai_activity);
        aiActivityTextView.setText(aiActivityTextView.getText()+"\n onCreate Executed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        aiActivityTextView.setText(aiActivityTextView.getText()+"\n onStart Executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        aiActivityTextView.setText(aiActivityTextView.getText()+"\n onStop Executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        aiActivityTextView.setText(aiActivityTextView.getText()+"\n onDestroy Executed");
    }
}