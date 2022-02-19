package com.example.simpleviewmodelexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private NameViewModel model;
    private TextView nameTextView;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Other code to setup the activity...
        nameTextView=findViewById(R.id.nameTextView);
        btnUpdate=findViewById(R.id.btnUpdate);
        //update the value of the LiveData object,
        //which triggers all observers when the user taps the button
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hard code the value to update the UI
                String anotherName = "John Smith";
                //display the name on text view
                // do this through the model
                model.getCurrentName().setValue(anotherName);
            }
        });

        // Get the ViewModel that will handle your operation
        model = ViewModelProviders.of(this).get(NameViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            //called when the data is changed
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                nameTextView.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity
        // as the LifecycleOwner and the observer.
        model.getCurrentName().observe(this, nameObserver);
    }
}
