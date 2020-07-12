package com.example.quanlybanmyphamonline.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.quanlybanmyphamonline.Adapter.GioHangAdapter;
import com.example.quanlybanmyphamonline.Class.GioHang;
import com.example.quanlybanmyphamonline.R;

public class GioHangActivity extends AppCompatActivity {

    ListView lstgiohang;
    TextView txtThongBao;
    TextView txtTongTien;
    Button btnTienHanhThanhToan;
    public Toolbar toolbarGioHang;
    GioHangAdapter gioHangAdapter;
    private Toolbar supportActionBar;
    LinearLayout linearLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        AnhXa();
        //setSupportActionBar(toolbarGioHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbarGioHang.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        checkData();
        eventTinhTien();
        btnTienHanhThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GioHangActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void eventTinhTien() {
        int tongtien = 0;
        for(int i =0;i<MainActivity.mangGioHang.size();i++)
        {
            tongtien += MainActivity.mangGioHang.get(i).getGiasp();
        }
        txtTongTien.setText(tongtien+"");
    }

    private void checkData() {
        if(MainActivity.mangGioHang.size() <=0)
        {
            linearLayout.setVisibility(View.GONE);
            lstgiohang.deferNotifyDataSetChanged();
            txtThongBao.setVisibility(View.VISIBLE);
            lstgiohang.setVisibility(View.INVISIBLE);
            btnTienHanhThanhToan.setText("Tiếp tục mua sắm");
        }
        else
        {
            lstgiohang.deferNotifyDataSetChanged();
            txtThongBao.setVisibility(View.INVISIBLE);
            lstgiohang.setVisibility(View.VISIBLE);

        }
    }


    private void AnhXa() {
        lstgiohang = findViewById(R.id.listViewGioHang);
        txtThongBao = findViewById(R.id.textViewThongBao);
        txtTongTien = findViewById(R.id.textViewTongTien);
        btnTienHanhThanhToan = findViewById(R.id.buttonTienHanhDatHang);
        //toolbarGioHang = findViewById(R.id.toolbarGioHang);
        gioHangAdapter = new GioHangAdapter(GioHangActivity.this,MainActivity.mangGioHang);
        lstgiohang.setAdapter(gioHangAdapter);
        linearLayout = findViewById(R.id.linearTien);

    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}