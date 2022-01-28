package com.example.simpleviews4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showExample(View view)
    {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnDatePicker:
                intent = new Intent(this, DatePickerActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDatePickerDialog:
                intent = new Intent(this, DatePickerDialogActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }
}