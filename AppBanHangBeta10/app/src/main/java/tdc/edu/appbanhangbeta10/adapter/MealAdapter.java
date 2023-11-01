package tdc.edu.appbanhangbeta10.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import tdc.edu.appbanhangbeta10.databinding.ItemMealLeftBinding;
import tdc.edu.appbanhangbeta10.models.Meals;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MyViewHolder> {

    private List<Meals> mealsList;

    public MealAdapter(List<Meals> mealsList) {
        this.mealsList = mealsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMealLeftBinding binding = ItemMealLeftBinding.inflate(LayoutInflater.from(parent.getContext()),parent);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setBinding(mealsList.get(position));
        Glide.with(holder.itemView).load(mealsList.get(position).getStrMealThum()).into(holder.binding.CircleImageView);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemMealLeftBinding binding;

        public MyViewHolder(ItemMealLeftBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        private void setBinding(Meals meals){
            binding.setMealItems(meals);
            binding.executePendingBindings();
        }

    }
}
