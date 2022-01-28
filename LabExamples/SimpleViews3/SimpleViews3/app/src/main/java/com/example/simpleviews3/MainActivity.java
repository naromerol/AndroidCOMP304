package com.example.simpleviews3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //read the string-array from resources
        String[] programs = getResources().getStringArray(R.array.programs);
        //create the array adapter to hold array items
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, programs);
        //create the auto text view object
        AutoCompleteTextView autoCompletTextView = (AutoCompleteTextView)
                findViewById(R.id.txtPrograms);
        //connect the adapter with autocompletetextview object
        //and set the number of characters needed to type
        autoCompletTextView.setThreshold(1);
        //bind the array to the autocomplete textview
        autoCompletTextView.setAdapter(adapter);
    }
}