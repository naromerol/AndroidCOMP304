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

       // Intent intent = new Intent(this, MainActivity2.class);
       // startActivity(intent);
        Bundle values = getIntent().getExtras(); // Need a reference to Intent
        String name = values.getString("EmployeeName");
        int empID = values.getInt("EmployeeId");
        float sal =  values.getFloat("Salary");
        Toast.makeText(this, "Employeee ID:" + empID + "\nEmployee Name: " + name + "\nSalary: " + sal, Toast.LENGTH_SHORT ).show();

    } // end method
} // end class