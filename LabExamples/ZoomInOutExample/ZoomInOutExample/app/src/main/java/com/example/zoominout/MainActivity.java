package com.example.zoominout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.Image;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button buttonZoomIn;
    private Button buttonZoomOut;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonZoomIn = (Button)findViewById(R.id.btnZoomIn);
        buttonZoomOut = (Button)findViewById(R.id.btnZoomOut);
        img = (ImageView)findViewById(R.id.imgvw);
        buttonZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                img.startAnimation(animZoomIn);
            }
        });
        buttonZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                img.startAnimation(animZoomOut);
            }
        });
    }
}
