package com.example.courseregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class SoftEngActivity extends MenuActivity {
    //
    Set<String> setCourses = new HashSet<String>();
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String[] availableCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_eng);
        //get available courses from string array
        availableCourses = getResources().getStringArray(R.array.available_courses);
        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named courses
        setCourses = myPref.getStringSet("courses",new HashSet<String>());
        for( String strCourse : setCourses ){
            Toast.makeText(this, "Selected courses: "+strCourse, Toast.LENGTH_SHORT).show();
            // restore the state of check boxes according to shared preferences values
            if(strCourse.equals("Android"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBoxAndroid);
                checkBox1.setChecked(true);

            }
            if(strCourse.equals("Data Structures"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBoxDataStructures);
                checkBox1.setChecked(true);

            }
        }

        String myString = myPref.getString("program","");
        Toast.makeText(this, "Retrieving from shared preferences: "+myString, Toast.LENGTH_SHORT).show();
        prefEditor= myPref.edit();
    }
    //
    public void onCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxAndroid:
                if (checked) { //add it to the set
                    setCourses.add("Android");
                }
                else //remove it from the set
                {
                    setCourses.remove("Android");
                }
                break;

            case R.id.checkBoxDataStructures:
                if (checked) {
                    setCourses.add("Data Structures");
                }
                else
                {
                    setCourses.remove("Data Structures");
                }
                break;

            case R.id.checkBoxSoftwareTesting:
                if (checked)
                    setCourses.add("Software Testing");
                else
                    setCourses.remove("Software Testing");
                break;

            case R.id.checkBoxLinearAlgebra:
                 if (checked)
                    setCourses.add("Linear Algebra");
                else
                    setCourses.remove("Linear Algebra");
                break;

            case R.id.checkBoxProgramming3:
            if (checked)
                setCourses.add("Programming 3");
            else
                setCourses.remove("Programming 3");
            break;

            case R.id.checkBoxNetworking:
                if (checked)
                    setCourses.add("Networking");
                else
                    setCourses.remove("Networking");
                break;

            default:
                break;
        }

    }
    //
    public void onClickNext(View view)
    {

        Toast.makeText(this, "Number of selected courses: "+setCourses.size(), Toast.LENGTH_SHORT).show();

        //using enhanced for loop to show selected courses
        for( String strCourse : setCourses ){
            Toast.makeText(this, "Selected courses: "+strCourse, Toast.LENGTH_SHORT).show();
        }
        //add the selected courses to shared preferences variable named courses
        prefEditor.putStringSet("courses",setCourses);
        prefEditor.commit();
        //
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
}
