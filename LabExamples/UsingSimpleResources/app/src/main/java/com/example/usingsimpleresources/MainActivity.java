package com.example.usingsimpleresources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//show the UI
        setContentView(R.layout.activity_main);
        //read the resources defined in strings, colors, dimens files
        String myString = getResources().getString(R.string.display) ;
        int myColor= ContextCompat.getColor(this, R.color.niceTextColor);
        float myDimen = getResources().getDimension(R.dimen.textPointSize);
        //create a ColorDrawable from XML definition
        ColorDrawable myDraw = (ColorDrawable)ContextCompat.getDrawable(this,R.drawable.red_rect);
        //
        //create the Java object for your image view
        ImageView imgView = (ImageView)findViewById(R.id.imageView1);
        //get the flag image from resources
        BitmapDrawable bitmapFlag = (BitmapDrawable)ContextCompat.getDrawable(this, R.drawable.flag);
        //
        //display the drawable on image view
        imgView.setImageDrawable(myDraw);
        // get the flavors from string array
        String[] notFlavors = getResources().getStringArray(R.array.flavors);
        //create text view objects from their XML definitions
        TextView txtTitle = findViewById(R.id.txtView);
        txtTitle.setTextColor(myColor);
        //
        TextView tv = findViewById(R.id.txtView);
        // change size, color, and text
        tv.setTextSize(myDimen);
        tv.setTextColor(myColor);
        tv.setText(myString);
        //
    }
}
