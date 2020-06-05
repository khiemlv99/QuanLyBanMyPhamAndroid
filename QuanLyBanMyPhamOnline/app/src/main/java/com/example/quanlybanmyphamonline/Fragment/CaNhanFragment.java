package com.example.quanlybanmyphamonline.Fragment;

import android.app.ActionBar;
import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.quanlybanmyphamonline.DangNhap_DangKyActivity;
import com.example.quanlybanmyphamonline.R;

public class CaNhanFragment extends Fragment {

    Button btnDangNhapDangKy;

    public CaNhanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ca_nhan, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        btnDangNhapDangKy = view.findViewById(R.id.buttonDangNhapDangKy);
        btnDangNhapDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DangNhap_DangKyActivity.class);
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
