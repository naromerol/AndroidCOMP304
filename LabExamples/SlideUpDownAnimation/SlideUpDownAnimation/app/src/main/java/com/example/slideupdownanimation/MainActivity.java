package com.example.slideupdownanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button buttonSlideDown;
    private Button buttonSlideUp;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSlideDown = (Button)findViewById(R.id.btnSlideDown);
        buttonSlideUp = (Button)findViewById(R.id.btnSlideUp);
        img = (ImageView)findViewById(R.id.imgvw);
        buttonSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                img.startAnimation(animSlideDown);
            }
        });
        buttonSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
                img.startAnimation(animSlideUp);
            }
        });
    }
}
