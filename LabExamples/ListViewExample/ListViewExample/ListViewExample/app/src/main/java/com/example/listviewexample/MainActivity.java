package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter aAdapter;
    private String[] users = { "John Smith", "James white", "Paul Martin", "Praveen Zubeida", "Jason Brown", "Tom Doug"};
    private String[] courses = { "Java", "Android", "CSharp", "Python", "Kotlin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.userlist);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, courses);
        mListView.setAdapter(aAdapter);
    }
}