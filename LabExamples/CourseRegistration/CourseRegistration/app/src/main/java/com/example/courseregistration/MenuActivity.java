package com.example.courseregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.HashSet;

public class MenuActivity extends AppCompatActivity {
    //preference data variable
    private SharedPreferences myPreference;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }
    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.set_y:
                Toast.makeText(this, "You selected SET!", Toast.LENGTH_LONG).show();
                //instantiate the preference data variable
                myPreference = getSharedPreferences("info", 0);
                //prepare it for edit by creating and Edit object
                prefEditor = myPreference.edit();
                //store "set" in  a preference named "program"
                prefEditor.putString("programName", "SET");
                //commit the transaction
                prefEditor.commit();
                //show SoftEngActivity
                intent = new Intent(this, SoftEngActivity.class);
                startActivity(intent);
                break;

            case R.id.hit:
                Toast.makeText(this, "You selected HIT!", Toast.LENGTH_LONG).show();
                //show HealthInformaticsActivity
                intent = new Intent(this, HealthInformaticsActivity.class);
                startActivity(intent);
                break;

            case R.id.game_programming:
                Toast.makeText(this, "You selected Game Programming!", Toast.LENGTH_LONG).show();
                //show GamingActivity
                intent = new Intent(this, GamingActivity.class);
                startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;

    }
}