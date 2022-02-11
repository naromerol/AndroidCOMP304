package com.example.nestorromero_comp304sec004_lab01_ex02;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Fragment to handle the list / selection of activities
 */
public class ActivityListFragment extends ListFragment {

    String[] activities = new String[]{"AI Activity", "VR Activity"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_activity_list, container, false);
        ArrayAdapter<String> activityListAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, activities);
        setListAdapter(activityListAdapter);

        //Toast message
        Toast.makeText(getActivity(), "ActivityList onCreateView Executed", Toast.LENGTH_SHORT).show();
        return fragmentView;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {

        Intent intent = new Intent(getActivity(), AIActivity.class);
        if (position == 1){
            intent = new Intent(getActivity(), VRActivity.class);
        }
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        //Toast message
        Toast.makeText(getActivity(), "ActivityList onStart Executed", Toast.LENGTH_SHORT).show();
    }
}