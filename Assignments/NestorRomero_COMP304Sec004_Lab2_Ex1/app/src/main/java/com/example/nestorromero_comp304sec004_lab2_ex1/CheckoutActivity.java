package com.example.nestorromero_comp304sec004_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nestorromero_comp304sec004_lab2_ex1.data.DataService;
import com.example.nestorromero_comp304sec004_lab2_ex1.data.RealEstateUnit;

/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * Activity for checkout the definitive unit selection
 */
public class CheckoutActivity extends AppCompatActivity {

    private DataService dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Get instance of data service
        dataService = DataService.getInstance();

        //Read preferences set from all unit list activities
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.preferences_name), 0);

        RadioGroup radioGroup = findViewById(R.id.unit_radio_group);
        int radioCounter = 0;
        for ( String key : preferences.getAll().keySet() ){
            //String content += "key: " + key + " value: " + preferences.getAll().get(key) + "\n";
            RealEstateUnit unit = dataService.getUnitById(key);
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(unit.getAddress() + " | " + String.format("$ %,.2f", unit.getRentPrice()));
            radioButton.setId(View.generateViewId());
            radioButton.setTag(unit.getId());//Set ID as tag for data retrieval
            radioGroup.addView(radioButton);
            radioCounter++;
        }

        Button continueButton = findViewById(R.id.btn_continue);
        //Only if options exist the continue button will be available
        if(radioCounter<1){
            continueButton.setVisibility(View.INVISIBLE);
        }

    }

    public void onBackClick(View view){
        startActivity(new Intent(this, UnitTypesActivity.class));
    }

    public void onContinueClick(View view){
        //Validate selection
        RadioGroup radioGroup = findViewById(R.id.unit_radio_group);
        RadioButton selected = findViewById(radioGroup.getCheckedRadioButtonId());
        if(selected != null){
            String unitId = (String)selected.getTag();
            //Include Checkbox information into SharedPreferences
            SharedPreferences preferences = this.getSharedPreferences(
                    this.getString(R.string.preferences_name), 0);

            SharedPreferences.Editor prefEditor = preferences.edit();
            prefEditor.putString(getString(R.string.app_name), unitId);
            prefEditor.commit();
            Toast.makeText(getApplicationContext(),unitId + " Confirmed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, PaymentActivity.class));
        }


    }
}