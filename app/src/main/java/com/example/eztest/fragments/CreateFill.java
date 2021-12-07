package com.example.eztest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eztest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateFill#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateFill extends Fragment {



    public CreateFill() {
        // Required empty public constructor
    }

    public static CreateFill newInstance() {
        CreateFill fragment = new CreateFill();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_fill, container, false);
    }
}