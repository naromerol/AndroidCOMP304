package com.example.intentexample01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    } // end method


    public void buttonAct1Next_OnClick(View view) {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

        /*
        // If you want to send values to second activity..
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("EmployeeName", "Centennial");
        intent.putExtra("EmployeeId", 123);
        intent.putExtra("Salary", 2545.00);
        startActivity(intent);
*/
    }
} // end class