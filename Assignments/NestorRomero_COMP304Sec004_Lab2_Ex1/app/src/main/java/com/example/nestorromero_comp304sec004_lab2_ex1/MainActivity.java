package com.example.nestorromero_comp304sec004_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * Main activity for the application
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterButton = findViewById(R.id.button_welcome_app);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(view.getContext(), UnitTypesActivity.class));

            }
        });

        //Clear preferences for application initialization
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.preferences_name), 0);
        preferences.edit().clear().commit();


    }


}