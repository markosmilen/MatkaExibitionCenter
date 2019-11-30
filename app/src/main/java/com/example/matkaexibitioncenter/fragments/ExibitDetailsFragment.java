package com.example.matkaexibitioncenter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matkaexibitioncenter.R;

public class ExibitDetailsFragment extends Fragment {
    public static final String TAG = ExibitDetailsFragment.class.getCanonicalName();


    public static ExibitDetailsFragment newInstance (){
        ExibitDetailsFragment exibitDetailsFragment = new ExibitDetailsFragment();
        return exibitDetailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exibit_details, container, false);
        return view;
    }
}
