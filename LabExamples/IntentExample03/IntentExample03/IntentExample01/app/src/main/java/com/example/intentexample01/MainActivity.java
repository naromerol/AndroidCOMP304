package com.example.intentexample01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // set up references
    EditText empID, empName, salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        empID = (EditText) findViewById(R.id.editTextEmpID);
        empName = (EditText) findViewById(R.id.editTextEmpName);
        salary =  (EditText) findViewById(R.id.editTextSalary);

    } // end method


    public void buttonAct1Next_OnClick(View view) {

        // If you want to send values to second activity..
        int Id = Integer.parseInt(empID.getText().toString());
        String name = empName.getText().toString();
        double sal = Double.parseDouble(salary.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("EmployeeID", Id);
        intent.putExtra("EmployeeName", name);
        intent.putExtra("Salary", sal);
        startActivity(intent);

    }
} // end class