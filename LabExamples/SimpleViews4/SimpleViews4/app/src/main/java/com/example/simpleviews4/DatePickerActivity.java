package com.example.simpleviews4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class DatePickerActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private DatePicker datePicker;
    //
    private int hour, minute;
    private int yr, month, day;
    private TextView textView;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        //
        //instantiate the text view
         textView = (TextView)findViewById(R.id.textView);
        //instantiate the date and time picker
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        //
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        //
        //---get the current date---
        Calendar today = Calendar.getInstance();
        yr = today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH);
        day = today.get(Calendar.DAY_OF_MONTH);
        //
        datePicker.init(datePicker.getYear(), datePicker.getMonth(),
                datePicker.getDayOfMonth(),new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                textView.setText(" "+monthOfYear+ " / "+ dayOfMonth + " / "+year);
            }
        } );
        //
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public void onTimeChanged(TimePicker view,
                                      int hourOfDay, int minute) {

                String meridiem = "AM";
                if(hourOfDay>11){
                    meridiem="PM";
                    hourOfDay=hourOfDay-12;
                }
                textView.setText(hourOfDay + ":" + minute + meridiem);
            }
        });


    }
}