package tdc.edu.appbanhangbeta10.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import tdc.edu.appbanhangbeta10.databinding.ItemRecyclerviewBinding;
import tdc.edu.appbanhangbeta10.models.Meals;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder>{

    private List<Meals> list;

    public PopularAdapter(List<Meals> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PopularAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerviewBinding itemCategoryBinding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.MyViewHolder holder, int position) {
        holder.setBinding(list.get(position));
        Glide.with(holder.itemView).load(list.get(position).getStrMealThum()).into(holder.binding.ImageViewID2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerviewBinding binding;

        public MyViewHolder(ItemRecyclerviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setBinding(Meals meals) {
            binding.setPopular(meals);
            binding.executePendingBindings();
        }
    }
}
