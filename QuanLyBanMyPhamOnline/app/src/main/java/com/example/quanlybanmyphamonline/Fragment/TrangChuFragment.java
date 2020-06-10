package com.example.quanlybanmyphamonline.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.quanlybanmyphamonline.Adapter.VerticalRecyclerViewAdapter;
import com.example.quanlybanmyphamonline.Class.HorizontalModel;
import com.example.quanlybanmyphamonline.Class.VerticalModel;
import com.example.quanlybanmyphamonline.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends Fragment {

    ViewFlipper viewFlipper;
    Animation in,out;
    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter adapter;
    ArrayList<VerticalModel> arrayListVertical;
    int[] arrayHinh ={R.drawable.account,R.drawable.dashboard,R.drawable.home,R.drawable.notification};
    public TrangChuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trang_chu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AnhXa();
        TaoPlipper();
        Recyclerview();

    }

    public void TaoPlipper()
    {
        for(int i =0 ; i < arrayHinh.length;i++ )
        {
            ImageView imageView= new ImageView(getContext());
            imageView.setImageResource(arrayHinh[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            viewFlipper.addView(imageView);
        }

        in= AnimationUtils.loadAnimation(getContext(),R.anim.fade_in);
        out= AnimationUtils.loadAnimation(getContext(),R.anim.fade_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }

    public void AnhXa()
    {
        verticalRecyclerView =getView().findViewById(R.id.recyclerView);
        viewFlipper=getView().findViewById(R.id.viewPlipper);
    }

    public void Recyclerview()
    {
        arrayListVertical= new ArrayList<>();
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),RecyclerView.VERTICAL,false));
        adapter = new VerticalRecyclerViewAdapter(this.getContext(),arrayListVertical);
        setData();
        verticalRecyclerView.setAdapter(adapter);

    }

    private void setData() {
        for(int i = 1 ; i <= 5 ; i ++)
        {
            VerticalModel verticalModel = new VerticalModel();
            verticalModel.setTilte("Title"+i);
            ArrayList<HorizontalModel> horizontalModelArrayList = new ArrayList<>();

            for(int j = 0 ; j <= 5 ; j ++)
            {
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setDescription("Hello"+1);
                horizontalModel.setName("Tuan"+1);
                horizontalModelArrayList.add(horizontalModel);

            }
            verticalModel.setArrayList(horizontalModelArrayList);
            arrayListVertical.add(verticalModel);
        }
        adapter.notifyDataSetChanged();
    }


}
