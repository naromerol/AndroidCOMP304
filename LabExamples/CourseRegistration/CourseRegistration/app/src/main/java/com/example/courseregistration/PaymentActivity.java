package com.example.courseregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class PaymentActivity extends MenuActivity {
    private SharedPreferences myPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        //Toast.makeText(this, "payed courses ", Toast.LENGTH_LONG).show();

        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        String programName = myPreference.getString("programName","");
        Set<String> courses = myPreference.getStringSet("courses",new HashSet<String>());
        //Toast.makeText(this, "Number of selected courses "+courses.size(), Toast.LENGTH_SHORT).show();
        TextView tvCourses = (TextView)findViewById(R.id.tvCourses);
        tvCourses.setText("Program name: " + programName+"\n\n" + "Selected courses:" + "\n");
        //using enhanced for loop
        for( String strCourse : courses ){
            tvCourses.setText(tvCourses.getText().toString()+strCourse +"\n");
        }
    }
}