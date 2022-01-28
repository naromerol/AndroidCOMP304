package com.example.simplelayoutmanagers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnLinear:
                setContentView(R.layout.linear_layout);
                break;
            case R.id.btnFrame:
                setContentView(R.layout.frame_layout);
                break;
            case R.id.btnTable:
                setContentView(R.layout.table_layout);
                break;
            case R.id.btnRelative:
                setContentView(R.layout.relative_layout);
                break;
            case R.id.btnAbsolute:
                setContentView(R.layout.absolute_layout);
                break;
            case R.id.btnScroll:
                setContentView(R.layout.scroll_layout);
                break;
            default: setContentView(R.layout.activity_main);
        }
    }

    @Override
    public void onBackPressed(){
        //show the previous view
        setContentView(R.layout.activity_main);

    }
}
