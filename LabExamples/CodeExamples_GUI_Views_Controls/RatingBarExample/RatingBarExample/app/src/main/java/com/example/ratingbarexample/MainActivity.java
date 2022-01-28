package com.example.ratingbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new
           RatingBar.OnRatingBarChangeListener()
           {
               public void onRatingChanged(RatingBar ratingBar,
                                           float rating, boolean fromTouch)
               {
                   ((TextView)findViewById(R.id.textView)).setText("Rating: "+ rating);
               }
           });

    }
    public void rateService(View v){
        String rating=String.valueOf(ratingBar.getRating());
        Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
    }
}