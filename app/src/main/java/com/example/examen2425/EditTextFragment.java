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

public class EditTextFragment extends Fragment {
    public EditTextFragment(){
        super(R.layout.edit_text_fragment);
    }

    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.edit_text_fragment, container, false);
        SeekBar seekBarSize = rootView.findViewById(R.id.seekBarSize);
        seekBarSize.setMax(100);
        EditText editText = rootView.findViewById(R.id.editText);



        // Get reference to the ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Find the button and set a click listener
        Button button = rootView.findViewById(R.id.buttonSetText);
        button.setOnClickListener(v -> {

            sharedViewModel.setText(editText.getText().toString());
            sharedViewModel.setSize(seekBarSize.getProgress());
        });

        return rootView;
    }
}
