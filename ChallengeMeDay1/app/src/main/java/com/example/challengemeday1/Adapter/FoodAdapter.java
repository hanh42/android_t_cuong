package com.example.challengemeday1.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challengemeday1.Model.Food;
import com.example.challengemeday1.R;

import org.w3c.dom.Text;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    //B1 : Definitions variable
    private Activity activity;
    private int layoutId;
    private List<Food> foods;
    //B2 Create variable
    OnRecyclerItemViewClickListener onRecyclerItemViewClickListener;

    //B2 : Create constructor
    public FoodAdapter(Activity activity, int layoutId, List<Food> foods) {
        this.activity = activity;
        this.layoutId = layoutId;
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        CardView cardView = (CardView) layoutInflater.inflate(viewType, viewGroup, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Food food = foods.get(position);
        holder.txtName.setText(food.getName());
        holder.txtPrice.setText(food.getPrice() + " $ ");
        holder.imageView.setImageDrawable(activity.getResources().getDrawable(food.getPicture(), activity.getTheme()));
        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRecyclerItemViewClickListener != null) {
                    onRecyclerItemViewClickListener.onItemClickListener(position, holder.itemView);
                }
            }
        };
        holder.onLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                boolean flag = false;
                if (onRecyclerItemViewClickListener != null) {
                    onRecyclerItemViewClickListener.onItemLongClickListener(position, holder.itemView);
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


    //Definitions view holder
    protected static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView imageView;
        TextView txtName;
        TextView txtPrice;
        View.OnClickListener onClickListener;

        View.OnLongClickListener onLongClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_item_id);
            txtName = itemView.findViewById(R.id.text_view_item_name_food_id);
            txtPrice = itemView.findViewById(R.id.text_view_item_price_id);
            //Register click event.
            imageView.setOnClickListener(this);
            txtName.setOnClickListener(this);
            txtPrice.setOnClickListener(this);
            //Register longClick
            imageView.setOnLongClickListener(this);
            txtName.setOnLongClickListener(this);
            txtPrice.setOnLongClickListener(this);
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
                onLongClickListener.onLongClick(v);
                flag = true;
            }
            return flag;
        }

        //        B1 Definitions interface
    }

    public interface OnRecyclerItemViewClickListener {
        public void onItemClickListener(int p, View cardView);

        public void onItemLongClickListener(int p, View CardView);
    }

    public void setOnRecyclerItemViewClickListener(OnRecyclerItemViewClickListener onRecyclerItemViewClickListener) {
        this.onRecyclerItemViewClickListener = onRecyclerItemViewClickListener;
    }
}
