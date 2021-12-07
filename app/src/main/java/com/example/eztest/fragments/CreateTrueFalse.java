package com.example.eztest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eztest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateTrueFalse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateTrueFalse extends Fragment {



    public CreateTrueFalse() {
        // Required empty public constructor
    }

    public static CreateTrueFalse newInstance() {
        CreateTrueFalse fragment = new CreateTrueFalse();
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
        return inflater.inflate(R.layout.fragment_create_true_false, container, false);
    }
}