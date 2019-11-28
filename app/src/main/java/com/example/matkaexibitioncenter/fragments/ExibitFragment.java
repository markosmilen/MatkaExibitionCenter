package com.example.matkaexibitioncenter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matkaexibitioncenter.R;

public class ExibitFragment extends Fragment {

    public static final String TAG = ExibitFragment.class.getSimpleName();

    public static ExibitFragment newInstance(){
        ExibitFragment exibitFragment = new ExibitFragment();
        return exibitFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exibit, container, false);
        return view;
    }



}
