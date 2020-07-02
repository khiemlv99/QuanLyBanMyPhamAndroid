package com.example.quanlybanmyphamonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlybanmyphamonline.R;

public class DangNhapActivity extends AppCompatActivity {

    ImageButton btnDangky;
    TextView tvLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_activity);

        ActionBar actionBar = getSupportActionBar();
//        Drawable drawable= getResources().getDrawable(R.drawable.delete36);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(drawable);
        actionBar.hide();

        AnhXa();
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });

    }

    private void AnhXa() {
        btnDangky = findViewById(R.id.imageButtonDangKy);
        tvLogin = findViewById(R.id.tvLogin);
    }



}
