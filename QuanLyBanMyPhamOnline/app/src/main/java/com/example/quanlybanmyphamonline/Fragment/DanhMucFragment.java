package com.example.quanlybanmyphamonline.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlybanmyphamonline.Adapter.ChiTietSPAdapter;
import com.example.quanlybanmyphamonline.Adapter.HorizontalRecylerViewAdapter;
import com.example.quanlybanmyphamonline.Adapter.LoaiSPAdapter;
import com.example.quanlybanmyphamonline.Class.ChiTietSanPham;
import com.example.quanlybanmyphamonline.Class.HorizontalModel;
import com.example.quanlybanmyphamonline.Class.LoaiSP;
import com.example.quanlybanmyphamonline.MyOnClickListener;
import com.example.quanlybanmyphamonline.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DanhMucFragment extends Fragment {

    String urlGetData ="http://192.168.56.1:8080/androidwebservice/getLoaiSP.php";
    String url = "http://192.168.56.1:8080/androidwebservice/getSPTheoLoai.php";
    ArrayList<LoaiSP> arr;
    LoaiSPAdapter adapter;
    ArrayList<HorizontalModel>arrChiTiet;
    HorizontalRecylerViewAdapter adapterChiTiet;
    int idloai ;

    public DanhMucFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_muc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = view.findViewById(R.id.recyclerview_1);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager
                (getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        arr = new ArrayList<>();


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i =0;i<response.length();i++)
                        {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arr.add(new LoaiSP(object.getInt("MaLoaiSanPham"),
                                        object.getString("TenLoaiSanPham"),
                                        object.getString("hinhloai")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        adapter = new LoaiSPAdapter(arr,getContext());
                        recyclerView.setAdapter(adapter);
                        adapter.setMyOnClickListener(new MyOnClickListener() {
                            @Override
                            public void onClick(LoaiSP loaiSP) {
                                //load chi tiet san pham
                                final RecyclerView recyclerView = view.findViewById(R.id.recyclerview_2);
                                recyclerView.setHasFixedSize(true);
                                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),
                                        3,RecyclerView.VERTICAL,false);
                                recyclerView.setLayoutManager(gridLayoutManager);
                                arrChiTiet = new ArrayList<>();
                                getData(loaiSP.getMaLoai(),recyclerView);


                            }
                        });

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);

        //load recycleview 2
        Toast.makeText(getContext(), "maloai="+idloai, Toast.LENGTH_SHORT).show();
    }

    public static DanhMucFragment newInstance(int pos)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("masp", pos);
        DanhMucFragment danhMucFragment = new DanhMucFragment();
        danhMucFragment.setArguments(bundle);
        return danhMucFragment;
    }

    public void getData(final int maloai, final RecyclerView re){

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for(int i =0;i<array.length();i++)
                    {
                        JSONObject object = array.getJSONObject(i);
                        arrChiTiet.add(new HorizontalModel(object.getInt("MaSanPham"),
                                object.getInt("MaLoaiSanPham"),
                                object.getString("TenSanPham"),
                                object.getString("MoTa"),
                                object.getString("HinhAnh"),

                                object.getInt("GiaSanPham"),

                                object.getInt("SoLuong")));
                    }
                    adapterChiTiet = new HorizontalRecylerViewAdapter(getContext(),arrChiTiet);
                    re.setAdapter(adapterChiTiet);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String ,String> param = new HashMap<String , String>();
                param.put("MaLoaiSanPham", String.valueOf(maloai));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
}
