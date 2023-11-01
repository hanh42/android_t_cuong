package com.example.swiperefreshlayout_day1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Activity activity;
    private int layout_ID;
    private ArrayList<Cart> arrayList;
    private MyAdapter.onRecyclerViewOnClickListener _onRecyclerViewOnClickListener;

    public MyAdapter(Activity activity, int layout_ID, ArrayList<Cart> arrayList) {
        this.activity = activity;
        this.layout_ID = layout_ID;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        CardView cardView = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyAdapter.MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cart cart = arrayList.get(position);
        holder.txt_name.setText(cart.getName());
        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_onRecyclerViewOnClickListener != null) {
                    _onRecyclerViewOnClickListener.onItemRecyclerViewOnClickListener(position, holder.itemView);
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layout_ID;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txt_name;
        private View.OnClickListener onClickListener;

        public MyViewHolder(@NonNull View v) {
            super(v);
            txt_name = v.findViewById(R.id.txt_name);
            //Catch event click
            txt_name.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    //B1: definitions interface
    public interface onRecyclerViewOnClickListener {
        public void onItemRecyclerViewOnClickListener(int p, View CardView);
    }
    //B4: Setter

    public void set_OnRecyclerViewOnClickListener(MyAdapter.onRecyclerViewOnClickListener _OnRecyclerViewOnClickListener) {
        this._onRecyclerViewOnClickListener = _OnRecyclerViewOnClickListener;
    }
}
