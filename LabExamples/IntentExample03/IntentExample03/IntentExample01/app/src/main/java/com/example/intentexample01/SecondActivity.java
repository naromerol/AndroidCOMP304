package com.example.intentexample01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void buttonAct2Next_OnClick(View view) {

        Bundle values = getIntent().getExtras(); // Need a reference to Intent
        int empID = values.getInt("EmployeeID");
        String name = values.getString("EmployeeName");
        double sal =  values.getDouble("Salary");
        //Toast.makeText(this, "Employee ID:" + empID + "\nEmployee Name: " + name + "\nSalary: " + sal, Toast.LENGTH_SHORT ).show();
        Toast.makeText(this, "Employee ID:" + String.valueOf(empID) + "\nEmployee Name: " + name + "\nSalary: " + String.valueOf(sal), Toast.LENGTH_SHORT ).show();

    } // end method
} // end class