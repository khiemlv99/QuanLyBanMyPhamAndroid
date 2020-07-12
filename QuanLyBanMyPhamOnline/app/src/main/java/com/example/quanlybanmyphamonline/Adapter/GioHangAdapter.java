package com.example.quanlybanmyphamonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlybanmyphamonline.Class.GioHang;
import com.example.quanlybanmyphamonline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<GioHang> arrayListGioHang;

    public GioHangAdapter(Context context, ArrayList<GioHang> arrayListGioHang) {
        this.context = context;
        this.arrayListGioHang = arrayListGioHang;
    }


    @Override
    public int getCount() {
        return arrayListGioHang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListGioHang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txtTieuDe, txtGia;
        ImageView imgHinhanh;
        Button btnGiam, btnGiaTri,btnTang;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(viewHolder == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_dong_giohang,null);
            viewHolder.txtTieuDe  = convertView.findViewById(R.id.textViewTieuDeGioHang);
            viewHolder.txtGia = convertView.findViewById(R.id.textViewGiaGioHang);
            viewHolder.imgHinhanh = convertView.findViewById(R.id.imgViewHinhGioHang);
            viewHolder.btnGiam = convertView.findViewById(R.id.buttonGiam);
            viewHolder.btnGiaTri = convertView.findViewById(R.id.buttonGiatri);
            viewHolder.btnTang = convertView.findViewById(R.id.buttonTang);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        GioHang gioHang = (GioHang) getItem(position);
        viewHolder.txtTieuDe.setText(gioHang.getTenSP());
        viewHolder.txtGia.setText(gioHang.getGiasp()+"");
        Picasso.get().load(gioHang.hinhanh).into(viewHolder.imgHinhanh);
        viewHolder.btnGiaTri.setText(gioHang.getSoluong()+"");
        return convertView;
    }
}
