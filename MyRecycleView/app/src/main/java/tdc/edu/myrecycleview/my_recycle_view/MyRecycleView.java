package tdc.edu.myrecycleview.my_recycle_view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import tdc.edu.myrecycleview.R;
import tdc.edu.myrecycleview.model.Person;

public class MyRecycleView extends RecyclerView.Adapter<MyRecycleView.MyViewHolder> {
    private Activity activity;
    private int layout_Id;
    private ArrayList<Person> personArrayList;
    private OnRecycleViewItemClickListener _onRecycleViewItemClickListener;

    public MyRecycleView(Activity activity, int layout_Id, ArrayList<Person> personArrayList) {
        this.activity = activity;
        this.layout_Id = layout_Id;
        this.personArrayList = personArrayList;
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
        Person person = personArrayList.get(position);
        holder.txt_name.setText(person.getName());
        holder.txt_hobbies.setText(person.getHobbies());
        //B3: Event click
        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_onRecycleViewItemClickListener != null) {
                    _onRecycleViewItemClickListener.onItemClickListener(position, holder.itemView);
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layout_Id;
    }

    //B1: Definitions a class viewHolder by extend RecycleView.ViewHolder implement Onclicklistener
    protected static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView txt_name;
        private TextView txt_hobbies;
        View.OnClickListener onClickListener;

        public MyViewHolder(@NonNull View v) {
            super(v);
            imageView = v.findViewById(R.id.ImageView_ID);
            txt_name = v.findViewById(R.id.TextViewName_ID);
            txt_hobbies = v.findViewById(R.id.TextViewHobbie_ID);
            //Catch all by one Event processing!
            imageView.setOnClickListener(this);
            txt_name.setOnClickListener(this);
            txt_hobbies.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    //B1: Definitions a interface
    public interface OnRecycleViewItemClickListener {
        public void onItemClickListener(int p, View cardView);
    }

    //B4: Getter for the interface variable
    public void set_onRecycleViewItemClickListener(OnRecycleViewItemClickListener _onRecycleViewItemClickListener) {
        this._onRecycleViewItemClickListener = _onRecycleViewItemClickListener;
    }
}