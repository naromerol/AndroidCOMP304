package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList userList = getListData();
        final ListView lv = (ListView) findViewById(R.id.user_list);
        lv.setAdapter(new CustomListAdapter(this, userList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem user = (ListItem) lv.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + user.getName()+", "+ user.getLocation(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private ArrayList getListData() {
        ArrayList<ListItem> results = new ArrayList<>();
        ListItem user1 = new ListItem();
        user1.setName("John Smith");
        user1.setDesignation("Lead Developer");
        user1.setLocation("Toronto");
        results.add(user1);
        ListItem user2 = new ListItem();
        user2.setName("Tyler");
        user2.setDesignation("Tech Support");
        user2.setLocation("Montreal");
        results.add(user2);
        ListItem user3 = new ListItem();
        user3.setName("Raj S");
        user3.setDesignation("Admin");
        user3.setLocation("York");
        results.add(user3);
        return results;
    }
}