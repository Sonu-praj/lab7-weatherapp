package com.cst2335.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WeatherFragment extends Fragment {

    private TextView weatherTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        weatherTextView = view.findViewById(R.id.text_weather); // Make sure this ID exists in fragment_weather.xml
        return view;
    }

    public void updateWeatherData(String weatherData) {
        if (weatherTextView != null) {
            weatherTextView.setText(weatherData); // Update UI with new weather data
        }
    }
}
