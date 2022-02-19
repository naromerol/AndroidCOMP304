package com.example.nestorromero_comp304sec004_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nestorromero_comp304sec004_lab2_ex1.data.DataService;
import com.example.nestorromero_comp304sec004_lab2_ex1.data.RealEstateUnit;

/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * Payment activity for the application
 */
public class PaymentActivity extends AppCompatActivity {

    private DataService dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //Get instance of data service
        dataService = DataService.getInstance();

        //Include Checkbox information into SharedPreferences
        SharedPreferences preferences = this.getSharedPreferences(
                this.getString(R.string.preferences_name), 0);

        String unitId = preferences.getString(getString(R.string.app_name), null);
        if(unitId != null ){
            RealEstateUnit unit = dataService.getUnitById(unitId);
            TextView detail = (TextView)findViewById(R.id.cc_detail);
            detail.setText(unit.toString());
        }


    }

    public void onFinishClick(View view){
        Toast.makeText(getApplicationContext(), "Transaction Completed", Toast.LENGTH_LONG).show();
    }
}