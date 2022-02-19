package com.example.rotateclockwiseanticlockwise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button buttontRotateClockwise;
    private Button buttontRotateAntiClockwise;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttontRotateClockwise = (Button)findViewById(R.id.btnRClk);
        buttontRotateAntiClockwise = (Button)findViewById(R.id.btnRAClk);
        img = (ImageView)findViewById(R.id.imgvw);
        buttontRotateClockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation aniRotateClk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
                img.startAnimation(aniRotateClk);
            }
        });
        buttontRotateAntiClockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animRotateAclk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
                img.startAnimation(animRotateAclk);
            }
        });
    }
}
