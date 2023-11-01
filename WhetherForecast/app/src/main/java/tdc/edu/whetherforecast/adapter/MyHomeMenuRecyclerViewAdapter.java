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

import org.w3c.dom.Text;

import java.util.ArrayList;

import tdc.edu.whetherforecast.R;
import tdc.edu.whetherforecast.model.Cart;

public class MyHomeMenuRecyclerViewAdapter extends RecyclerView.Adapter<MyHomeMenuRecyclerViewAdapter.MyViewHolder> {

    private Activity activity;
    private int layout_ID;
    private ArrayList<Cart> arrayList;
    private MyHomeMenuRecyclerViewAdapter.onRecyclerViewOnClickListener _onRecyclerViewOnClickListener;

    public MyHomeMenuRecyclerViewAdapter(Activity activity, int layout_ID, ArrayList<Cart> arrayList) {
        this.activity = activity;
        this.layout_ID = layout_ID;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHomeMenuRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        CardView cardView = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyHomeMenuRecyclerViewAdapter.MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHomeMenuRecyclerViewAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cart cart = arrayList.get(position);
        holder.txt_name.setText(cart.getName());
        holder.txt_price.setText(String.valueOf(cart.getPrice()));
        holder.txt_qtyStart.setText("(" + String.valueOf(cart.getRate()) + ")");
        holder.imageView.setImageDrawable(activity.getResources().getDrawable(cart.getImg(), activity.getTheme()));
        //holder.imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_launcher_background, activity.getTheme()));
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

    @Override
    public int getItemViewType(int position) {
        return layout_ID;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView txt_name;
        private TextView txt_price;
        private TextView txt_qtyStart;
        private Button btn_buy;

        private View.OnClickListener onClickListener;

        public MyViewHolder(@NonNull View v) {
            super(v);
            imageView = v.findViewById(R.id.img_menu_home_screen);
            txt_name = v.findViewById(R.id.txt_name_menu_home_screen);
            txt_price = v.findViewById(R.id.txt_price_menu_home_screen);
            txt_qtyStart = v.findViewById(R.id.txt_qty_start_menu_home_screen);
            btn_buy = v.findViewById(R.id.btn_buy_menu_home_screen);
            //Catch event click
            imageView.setOnClickListener(this);
            txt_name.setOnClickListener(this);
            txt_price.setOnClickListener(this);
            txt_qtyStart.setOnClickListener(this);
            btn_buy.setOnClickListener(this);
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

    public void set_OnRecyclerViewOnClickListener(MyHomeMenuRecyclerViewAdapter.onRecyclerViewOnClickListener _OnRecyclerViewOnClickListener) {
        this._onRecyclerViewOnClickListener = _OnRecyclerViewOnClickListener;
    }
}
