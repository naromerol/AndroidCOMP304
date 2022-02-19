package com.example.nestorromero_comp304sec004_lab2_ex1.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.nestorromero_comp304sec004_lab2_ex1.R;
import com.example.nestorromero_comp304sec004_lab2_ex1.data.RealEstateUnit;
import com.example.nestorromero_comp304sec004_lab2_ex1.data.RealEstateUnitType;

import java.util.ArrayList;
/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * This class is a custom adapter for displaying the ListView rows as more complex elements
 * containing an image, address, rent and selection field
 *
 */
public class UnitListAdapter extends ArrayAdapter<RealEstateUnit> {

    private Activity context;
    private ArrayList<RealEstateUnit> unitList;

    public UnitListAdapter(Activity context, ArrayList<RealEstateUnit> unitList) {

        super(context, R.layout.unit_row_layout, unitList);
        this.context = context;
        this.unitList = unitList;
    }

    static class RowViewHolder {
        protected TextView addressText;
        protected TextView rentText;
        protected ImageView unitImage;
        protected CheckBox unitSelected;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = null;
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.unit_row_layout, null);

            //Create references from layout to viewHolder object
            final RowViewHolder rowViewHolder = new RowViewHolder();
            rowViewHolder.addressText = rowView.findViewById(R.id.unit_address);
            rowViewHolder.rentText = rowView.findViewById(R.id.unit_rent);
            rowViewHolder.unitImage = rowView.findViewById(R.id.unit_image);
            rowViewHolder.unitSelected = rowView.findViewById(R.id.unit_selected);

            //Handle onCLick event for the Checkbox
            rowViewHolder.unitSelected
                    .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView,
                                                     boolean isChecked) {
                            RealEstateUnit unit = (RealEstateUnit) rowViewHolder.unitSelected.getTag();
                            unit.setSelected(buttonView.isChecked());

                            //Include Checkbox information into SharedPreferences
                            SharedPreferences preferences = context.getSharedPreferences(
                                    context.getString(R.string.preferences_name), 0);

                            SharedPreferences.Editor prefEditor = preferences.edit();
                            if (unit.isSelected()) {
                                prefEditor.putString(unit.getId(), unit.getId());
                                Toast.makeText(context,unit.getId() + " Added", Toast.LENGTH_SHORT).show();
                            } else {
                                prefEditor.remove(unit.getId());
                            }
                            prefEditor.commit();

                        }
                    });

            rowView.setTag(rowViewHolder);
            rowViewHolder.unitSelected.setTag(unitList.get(position));

        } else {

            rowView = convertView;
            ((RowViewHolder) rowView.getTag()).unitSelected.setTag(unitList.get(position));

        }

        RowViewHolder holder = (RowViewHolder) rowView.getTag();
        RealEstateUnit unit = unitList.get(position);
        holder.addressText.setText(unit.getAddress());
        holder.rentText.setText(String.format("$ %,.2f", unit.getRentPrice()));
        holder.unitSelected.setChecked(unit.isSelected());

        //Logic for dynamic display of images
        int imageId = R.drawable.apartment;
        switch (unit.getType()) {
            case APARTMENT:
                imageId = R.drawable.apartment;
                break;

            case CONDO:
                imageId = R.drawable.condo;
                break;

            case DETACHED:
                imageId = R.drawable.detached;
                break;

            case SEMIDETACHED:
                imageId = R.drawable.semidetached;
                break;

            case TOWNHOUSE:
                imageId = R.drawable.townhouse;
                break;
        }
        holder.unitImage.setImageDrawable(context.getDrawable(imageId));

        return rowView;
    }
}
