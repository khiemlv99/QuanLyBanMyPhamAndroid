package com.example.quanlybanmyphamonline.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlybanmyphamonline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DangKyFragment extends Fragment {

    public DangKyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dang_ky, container, false);
    }
}
