package com.example.fadeinout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button buttonFadeIn;
    private Button buttonFadeOut;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFadeIn = (Button)findViewById(R.id.btnFadeIn);
        buttonFadeOut = (Button)findViewById(R.id.btnFadeOut);
        img = (ImageView)findViewById(R.id.imgvw);
        /*
        buttonFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                img.startAnimation(animFadeIn);
            }
        });
         */
        buttonFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                img.startAnimation(animFadeOut);
            }
        });
    } // end onCreate

    public void FadeIn_Click(View view) {
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        img.startAnimation(animFadeIn);
    }
} // end Class