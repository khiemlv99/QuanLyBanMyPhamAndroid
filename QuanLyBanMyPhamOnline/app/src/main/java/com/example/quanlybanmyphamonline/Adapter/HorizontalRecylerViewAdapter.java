package com.example.quanlybanmyphamonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlybanmyphamonline.Class.HorizontalModel;
import com.example.quanlybanmyphamonline.Class.VerticalModel;
import com.example.quanlybanmyphamonline.R;

import java.util.ArrayList;

public class HorizontalRecylerViewAdapter extends RecyclerView.Adapter<HorizontalRecylerViewAdapter.HorizontalViewHolder> {

    public Context context;
    public ArrayList<HorizontalModel> arrayList;

    public  HorizontalRecylerViewAdapter(Context context , ArrayList<HorizontalModel>arrayList)
    {
        this.arrayList=arrayList;
        this.context=context;

    }
    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
            final HorizontalModel horizontalModel=arrayList.get(position);
            holder.textView.setText(horizontalModel.getName());
            holder.textView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
            holder.imageView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,horizontalModel.getName(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class  HorizontalViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);

            textView =(TextView)itemView.findViewById(R.id.txtTextTilteHorizontal);
            imageView=(ImageView)itemView.findViewById(R.id.Image);
        }
    }
}
