package com.cst2335.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RefreshButtonFragment extends Fragment {

    private OnRefreshButtonClickListener listener;

    public interface OnRefreshButtonClickListener {
        void onRefreshButtonClick();
    }

    @Override
    public void onAttach(@NonNull android.content.Context context) {
        super.onAttach(context);
        if (context instanceof OnRefreshButtonClickListener) {
            listener = (OnRefreshButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnRefreshButtonClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_refresh_button, container, false);

        Button refreshButton = view.findViewById(R.id.button_refresh); // Make sure this ID exists in fragment_refresh_button.xml
        refreshButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRefreshButtonClick(); // Notify MainActivity
            }
        });

        return view;
    }
}
