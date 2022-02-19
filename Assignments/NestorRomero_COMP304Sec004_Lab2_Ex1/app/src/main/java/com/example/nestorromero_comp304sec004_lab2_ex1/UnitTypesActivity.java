package com.example.nestorromero_comp304sec004_lab2_ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * Auxiliary screen to select unit types and provide intermediate navigation
 */
public class UnitTypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_types);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.unit_type_menu, menu);
        return true;
    }

    /**
     * This method handles click events from the options menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_apartment:
                startActivity(new Intent(this, ApartmentListActivity.class));
                break;

            case R.id.menu_item_condo:
                startActivity(new Intent(this, CondoListActivity.class));
                break;

            case R.id.menu_item_detached:
                startActivity(new Intent(this, DetachedListActivity.class));
                break;

            case R.id.menu_item_semidetached:
                startActivity(new Intent(this, SemiDetachedListActivity.class));
                break;

            case R.id.menu_item_townhouse:
                startActivity(new Intent(this, TownHouseListActivity.class));
                break;

        }
        return true;
    }

    /*
    The methods below help managing the buttons on the main screen of unit type selection
     */

    public void onApartmentClick(View view){
        startActivity(new Intent(this, ApartmentListActivity.class));
    }

    public void onCondoClick(View view){
        startActivity(new Intent(this, CondoListActivity.class));
    }

    public void onDetachedClick(View view){
        startActivity(new Intent(this, DetachedListActivity.class));
    }

    public void onSemiDetachedClick(View view){
        startActivity(new Intent(this, SemiDetachedListActivity.class));
    }

    public void onTownHouseClick(View view){
        startActivity(new Intent(this, TownHouseListActivity.class));
    }

    public void onCheckoutClick(View view){
        startActivity(new Intent(this, CheckoutActivity.class));
    }

}