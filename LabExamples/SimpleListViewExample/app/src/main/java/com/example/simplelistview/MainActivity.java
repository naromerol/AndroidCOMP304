package com.example.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private String[] cities = { "Toronto", "Bombay", "Ottawa", "London", "Rome", "Paris"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Setting up
        listView = (ListView) findViewById(R.id.citylist);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        listView.setAdapter(arrayAdapter);
    } // end method
}