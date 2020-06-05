package com.example.quanlybanmyphamonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    boolean status =false;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_trangchu);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;
            switch (item.getItemId())
            {
                case R.id.navigation_trangchu:
                    getSupportActionBar().setTitle("Trang chủ");
                    fragment = new Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_TimKiem:
                    getSupportActionBar().setTitle("Tìm kiếm");
                    fragment = new Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_Danhmuc:
                    getSupportActionBar().setTitle("Danh mục");
                    fragment = new Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_ThongBao:
                    getSupportActionBar().setTitle("Thông báo");
                    fragment = new Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_CaNhan:
                    getSupportActionBar().setTitle("Cá nhân");
                    fragment = new Fragment();
                    loadFragment(fragment);
                    return true;

            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
