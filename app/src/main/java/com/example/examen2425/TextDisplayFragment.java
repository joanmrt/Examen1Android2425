package com.example.examen2425;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class TextDisplayFragment extends Fragment {
    public TextDisplayFragment(){
        super(R.layout.text_display_fragment);

    }

    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.text_display_fragment, container, false);

        // Get reference to the ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        int red = 0;
        int green = 0;
        int blue = 0;
        // Get the TextView and observe the LiveData
        TextView textView = rootView.findViewById(R.id.textView);
        sharedViewModel.getText().observe(getViewLifecycleOwner(), text -> {
            // Update the TextView when the data changes
            textView.setText(text);

        });

        // Observe the textSize LiveData
        sharedViewModel.getSize().observe(getViewLifecycleOwner(), textSize -> {
            // Update the TextView text size when it changes
            textView.setTextSize(textSize);  // size in sp
        });

        // Observe the textSize LiveData
        sharedViewModel.getColorLiveData().observe(getViewLifecycleOwner(), colorData -> {
            // Update the TextView text size when it changes
              textView.setTextColor(Color.rgb(colorData.getRed(),colorData.getGreen(),colorData.getBlue()));
        });

        return rootView;
    }
}
