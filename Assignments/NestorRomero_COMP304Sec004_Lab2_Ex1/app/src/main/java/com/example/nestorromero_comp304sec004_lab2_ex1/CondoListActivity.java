package com.example.nestorromero_comp304sec004_lab2_ex1;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.nestorromero_comp304sec004_lab2_ex1.adapter.UnitListAdapter;
import com.example.nestorromero_comp304sec004_lab2_ex1.data.DataService;
import com.example.nestorromero_comp304sec004_lab2_ex1.data.RealEstateUnit;
import com.example.nestorromero_comp304sec004_lab2_ex1.data.RealEstateUnitType;

import java.util.ArrayList;

/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * List of condo units
 */
public class CondoListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condo_list);

        //Retrieve data for view
        DataService dataService = DataService.getInstance();
        ArrayList<RealEstateUnit> unitList = dataService.getUnitsByType(RealEstateUnitType.CONDO);

        //Use adapter to fill ListView
        UnitListAdapter adapter = new UnitListAdapter(this, unitList);
        setListAdapter(adapter);
    }

}