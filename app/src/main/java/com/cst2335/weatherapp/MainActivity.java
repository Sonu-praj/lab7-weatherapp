package com.cst2335.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements com.cst2335.weatherapp.RefreshButtonFragment.OnRefreshButtonClickListener {

    private com.cst2335.weatherapp.WeatherFragment weatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize fragments
        weatherFragment = new com.cst2335.weatherapp.WeatherFragment();
        com.cst2335.weatherapp.RefreshButtonFragment refreshButtonFragment = new com.cst2335.weatherapp.RefreshButtonFragment();

        // Add fragments to the layout
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container_weather, weatherFragment);
        fragmentTransaction.add(R.id.fragment_container_refresh_button, refreshButtonFragment);

        fragmentTransaction.commit();
    }

    @Override
    public void onRefreshButtonClick() {
        // Trigger FetchWeatherTask to fetch weather data
        new FetchWeatherTask().execute();
    }

    // AsyncTask to fetch weather data
    private class FetchWeatherTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            // Perform network request to fetch weather data
            // Replace this with actual API call logic
            try {
                Thread.sleep(2000); // Simulating network delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Sunny, 25°C"; // Simulated weather data
        }

        @Override
        protected void onPostExecute(String weatherData) {
            // Update the WeatherFragment with fetched data
            if (weatherFragment != null) {
                weatherFragment.updateWeatherData(weatherData);
            }
        }
    }
}
