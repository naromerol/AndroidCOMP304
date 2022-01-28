package com.example.implicitintentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // setting up references
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Extracting the values from Edit Text
        editText = (EditText) findViewById(R.id.editTextUrl);
    } // end method

    public void buttonClick_Tapped(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
        startActivity(intent);
    }

    // Event handler

} // end class