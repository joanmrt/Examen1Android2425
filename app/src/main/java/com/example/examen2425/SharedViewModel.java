package com.example.examen2425;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> text = new MutableLiveData<>();
    private final MutableLiveData<Integer> red = new MutableLiveData<>();
    private final MutableLiveData<Integer> green = new MutableLiveData<>();
    private final MutableLiveData<Integer> blue = new MutableLiveData<>();
    private final MutableLiveData<Integer> size = new MutableLiveData<>();
    private final MutableLiveData<ColorData> colorData = new MutableLiveData<>();



    public MutableLiveData<String> getText() {
        return text;
    }

    public MutableLiveData<Integer> getRed() {
        return red;
    }

    public MutableLiveData<Integer> getGreen() {
        return green;
    }

    public MutableLiveData<Integer> getBlue() {
        return blue;
    }

    public MutableLiveData<Integer> getSize() {
        return size;
    }

    public MutableLiveData<ColorData> getColorLiveData() {
        return colorData;
    }

    public void setText(String newText) {
        text.setValue(newText);
    }

    public void setRed(Integer newRed) {
        red.setValue(newRed);
    }

    public void setGreen(Integer newGreen) {
        green.setValue(newGreen);
    }

    public void setBlue(Integer newBlue) {
        blue.setValue(newBlue);
    }

    public void setSize(int newSize) {
        size.setValue(newSize);
    }
    public void setColor(int red, int green, int blue) {
        colorData.setValue(new ColorData(red, green, blue));
    }
}

