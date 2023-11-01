package tdc.edu.whetherforecast.adapter;

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

import tdc.edu.whetherforecast.R;
import tdc.edu.whetherforecast.activity.CartScreenActivity;
import tdc.edu.whetherforecast.model.Cart;

public class MyCartRecycleViewAdapter extends RecyclerView.Adapter<MyCartRecycleViewAdapter.MyViewHolder> {
    //B2: Definitions variable of this interface
    private onRecyclerViewOnClickListener _onRecyclerViewOnClickListener;
    private Activity activity;
    private int layout_id;
    private ArrayList<Cart> arrayList;
    public CartScreenActivity cartScreenActivity = new CartScreenActivity();


    public MyCartRecycleViewAdapter(Activity activity, int layout_id, ArrayList<Cart> arrayList) {
        this.activity = activity;
        this.layout_id = layout_id;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        CardView cardView = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cart cart = arrayList.get(position);
        holder.txt_name.setText(String.valueOf(cart.getName()));
        holder.txt_total.setText(cartScreenActivity.formatCurrentcy(cart.getPrice() + "") + " x " + cartScreenActivity.formatCurrentcy(cart.getQty() + "") + " = " + cartScreenActivity.formatCurrentcy((cart.getQty() * cart.getPrice()) + "") + " VND ");
        holder.txt_qty.setText(String.valueOf(cart.getQty()));
        //holder.typeWeather.setImageDrawable(activity.getResources().getDrawable(R.drawable.unknown, activity.getTheme()));
        //B3: Event click
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

    //Definitions getType
    @Override
    public int getItemViewType(int position) {
        return layout_id;
    }

    //Customize your viewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView txt_name;
        private TextView txt_total;
        private TextView txt_qty;
        private Button btn_delete;
        private Button plus;
        private Button sub;
        View.OnClickListener onClickListener;

        public MyViewHolder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img_cart_screen);
            txt_name = v.findViewById(R.id.txt_name_cart_Screen);
            txt_total = v.findViewById(R.id.txt_total_cart_screen);
            txt_qty = v.findViewById(R.id.txt_qty_cart_screen);
            btn_delete = v.findViewById(R.id.btn_delete_cart_screen);
            plus = v.findViewById(R.id.btn_plus_cart_screen);
            sub = v.findViewById(R.id.btn_sub_cart_screen);
            //Catch event
            img.setOnClickListener(this);
            txt_name.setOnClickListener(this);
            txt_total.setOnClickListener(this);
            txt_qty.setOnClickListener(this);
            btn_delete.setOnClickListener(this);
            plus.setOnClickListener(this);
            sub.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    //B1: Definition interface
    public interface onRecyclerViewOnClickListener {
        //p lay vi tri , cardView de lay layout_item ma da tao ra doi tuong thoi tiet do
        public void onItemRecyclerViewOnClickListener(int p, View CardView);
    }

    //B4: Setter for variable just definitions on top
    public void set_onRecyclerViewOnClickListener(onRecyclerViewOnClickListener _onRecyclerViewOnClickListener) {
        this._onRecyclerViewOnClickListener = _onRecyclerViewOnClickListener;
    }
}
