package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "NeRo::COMP304";
    Button addButton;
    TextView outputView;
    EditText inputOneTxt, inputTwoTxt;
    int inputOne, inputTwo, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize controls references
        addButton = (Button)findViewById(R.id.addBtn);
        inputOneTxt = (EditText)findViewById(R.id.inputOneTxt);
        inputTwoTxt = (EditText)findViewById(R.id.inputTwoTxt);
        outputView = (TextView) findViewById(R.id.outputView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    inputOne = Integer.parseInt(inputOneTxt.getText().toString());
                    inputTwo = Integer.parseInt(inputTwoTxt.getText().toString());
                    result = inputOne + inputTwo;
                    outputView.setText(String.valueOf(result));
                }catch (Exception ex)
                {
                    outputView.setText("Error " + ex.getMessage());
                    Log.d(TAG, "onClick: " + ex.getMessage());
                    ex.printStackTrace();
                }

            }
        });

    }
}