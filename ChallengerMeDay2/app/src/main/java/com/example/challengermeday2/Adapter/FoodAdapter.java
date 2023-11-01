package com.example.challengermeday2.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challengermeday2.Model.Food;
import com.example.challengermeday2.R;

import org.w3c.dom.Text;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    private int layoutId;
    private Activity activity;
    private List<Food> foods;

    private OnItemRecyclerViewListener onItemRecyclerViewListener;


    public FoodAdapter(int layoutId, Activity activity, List<Food> foods) {
        this.layoutId = layoutId;
        this.activity = activity;
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        CardView cardView = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Food food = foods.get(position);
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(activity, food.getImage()));
        holder.textView.setText(food.getName());

        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemRecyclerViewListener != null) {
                    onItemRecyclerViewListener.itemClickListener(position, (CardView) holder.itemView);
                }
            }
        };
        holder.onLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                boolean flag = false;
                if (onItemRecyclerViewListener != null) {
                    onItemRecyclerViewListener.itemLongLickListener(position, (CardView) holder.itemView);
                    flag = true;
                }
                return flag;
            }
        };
    }


    @Override
    public int getItemCount() {
        return foods.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutId;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ImageView imageView;
        private TextView textView;
        private View.OnClickListener onClickListener;
        private View.OnLongClickListener onLongClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgViewFoodItem);
            textView = itemView.findViewById(R.id.txtFoodItem);

            imageView.setOnClickListener(this);
            textView.setOnClickListener(this);
            imageView.setOnLongClickListener(this);
            textView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onClickListener != null) {
                onClickListener.onClick(v);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            boolean flag = false;
            if (onLongClickListener != null) {
                flag = true;
                onLongClickListener.onLongClick(v);
            }
            return flag;
        }
    }

    public interface OnItemRecyclerViewListener {
        public void itemClickListener(int pos, CardView cardView);

        public void itemLongLickListener(int pos, CardView cardView);
    }

    public void setOnItemRecyclerViewListener(OnItemRecyclerViewListener onItemRecyclerViewListener) {
        this.onItemRecyclerViewListener = onItemRecyclerViewListener;
    }
}
