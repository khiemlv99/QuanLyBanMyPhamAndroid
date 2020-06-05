package com.example.quanlybanmyphamonline;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlybanmyphamonline.Fragment.DangNhapFragment;

import java.util.zip.Inflater;

public class DangNhap_DangKyActivity extends AppCompatActivity {

    Button btnDangNhap, btnDangKy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_dangky_activity);

        ActionBar actionBar = getSupportActionBar();
        Drawable drawable= getResources().getDrawable(R.drawable.delete36);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        AnhXa();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhapFragment dangNhapFragment = new DangNhapFragment();
                loadFragment(dangNhapFragment);
            }
        });
    }

    private void AnhXa() {
        btnDangNhap = findViewById(R.id.buttonDangNhap);
        btnDangKy = findViewById(R.id.buttonDangKy);
    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layoutDangNhapDangky, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
