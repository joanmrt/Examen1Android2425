package com.example.examen2425;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class TextColorFragment extends Fragment {
    public TextColorFragment(){
        super(R.layout.text_color_fragment);

    }

    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.text_color_fragment, container, false);
        SeekBar seekBarRed = rootView.findViewById(R.id.seekBarRed);
        seekBarRed.setMax(255);
        SeekBar seekBarGreen = rootView.findViewById(R.id.seekBarGreen);
        seekBarRed.setMax(255);
        SeekBar seekBarBlue = rootView.findViewById(R.id.seekBarBlue);
        seekBarRed.setMax(255);


        // Get reference to the ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Find the button and set a click listener
        Button button = rootView.findViewById(R.id.buttonSetColor);
        button.setOnClickListener(v -> {

            sharedViewModel.setRed(seekBarRed.getProgress());
            sharedViewModel.setGreen(seekBarGreen.getProgress());
            sharedViewModel.setBlue(seekBarBlue.getProgress());


        });

        return rootView;
    }
}
