package com.example.quanlybanmyphamonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.FrameLayout;

import com.example.quanlybanmyphamonline.Fragment.CaNhanFragment;
import com.example.quanlybanmyphamonline.Fragment.DanhMucFragment;
import com.example.quanlybanmyphamonline.Fragment.ThongBaoFragment;
import com.example.quanlybanmyphamonline.Fragment.TimKiemFragment;
import com.example.quanlybanmyphamonline.Fragment.TrangChuFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    boolean status =false;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4BCEDF")));

        bottomNavigationView = findViewById(R.id.nav_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_trangchu);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.navigation_trangchu:
                    getSupportActionBar().setTitle("Trang chủ");
                    TrangChuFragment fragment = new TrangChuFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_TimKiem:
                    getSupportActionBar().setTitle("Tìm kiếm");
                    TimKiemFragment timKiemFragment = new TimKiemFragment();
                    loadFragment(timKiemFragment);
                    return true;
                case R.id.navigation_Danhmuc:
                    getSupportActionBar().setTitle("Danh mục");
                    DanhMucFragment danhMucFragment = new DanhMucFragment();
                    loadFragment(danhMucFragment);
                    return true;
                case R.id.navigation_ThongBao:
                    getSupportActionBar().setTitle("Thông báo");
                    ThongBaoFragment thongBaoFragment = new ThongBaoFragment();
                    loadFragment(thongBaoFragment);
                    return true;
                case R.id.navigation_CaNhan:
                    getSupportActionBar().setTitle("Cá nhân");
                    CaNhanFragment caNhanFragment = new CaNhanFragment();
                    loadFragment(caNhanFragment);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
