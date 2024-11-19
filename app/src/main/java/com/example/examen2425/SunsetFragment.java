package com.example.examen2425;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class SunsetFragment extends Fragment {
    public SunsetFragment(){
        super(R.layout.sunset_fragment);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the ImageView inside the fragment's view hierarchy
        ImageView sun = view.findViewById(R.id.sun);
        View root = view.findViewById(R.id.SunsetRoot);

        // Create an ObjectAnimator to move the ImageView down
        ObjectAnimator moveDown = ObjectAnimator.ofFloat(sun, "translationY", 0f, 750f);
        moveDown.setDuration(3000); // Duration in milliseconds

        ObjectAnimator changeBackgroundColorToSunset = ObjectAnimator.ofObject(root, "backgroundColor", new ArgbEvaluator(),
                getResources().getColor(R.color.blue_sky), getResources().getColor(R.color.sunset_sky)); // Define colors
        changeBackgroundColorToSunset.setDuration(3000); // Duration for color change

        ObjectAnimator changeBackgroundColorToNight = ObjectAnimator.ofObject(root, "backgroundColor", new ArgbEvaluator(),
                getResources().getColor(R.color.sunset_sky), getResources().getColor(R.color.night_sky)); // Define colors
        changeBackgroundColorToNight.setDuration(1500); // Duration for color change

        // Optionally, combine with other animations in an AnimatorSet
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(moveDown, changeBackgroundColorToSunset);
        animatorSet.play(changeBackgroundColorToNight).after(changeBackgroundColorToSunset);

        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, android.view.MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    // Start the animation when the user touches the screen
                    animatorSet.start();
                    return true; // Indicate that the touch event was handled
                }
                return false; // Let the system handle the event otherwise
            }
        });


    }
}
