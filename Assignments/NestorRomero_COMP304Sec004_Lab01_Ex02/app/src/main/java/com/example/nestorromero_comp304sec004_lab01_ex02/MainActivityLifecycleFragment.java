package com.example.nestorromero_comp304sec004_lab01_ex02;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainActivityLifecycleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityLifecycleFragment extends Fragment {

    TextView mainActivityLifecycleTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_main_activity_lifecycle, container, false);
        mainActivityLifecycleTextView = fragmentView.findViewById(R.id.textview_lifecycle_messages);

        //Toast message
        Toast.makeText(getActivity(), "MainActivityLifecycle onCreateView Executed", Toast.LENGTH_SHORT).show();

        return fragmentView;
    }

    /**
     * Appends the message to the original contents
     * @param message
     */
    public void displayMessage(String message){
        if(mainActivityLifecycleTextView != null){
            mainActivityLifecycleTextView.setText(mainActivityLifecycleTextView.getText() + "\n" + message);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //Toast message
        Toast.makeText(getActivity(), "MainActivityLifecycle onStart Executed", Toast.LENGTH_SHORT).show();
    }
}