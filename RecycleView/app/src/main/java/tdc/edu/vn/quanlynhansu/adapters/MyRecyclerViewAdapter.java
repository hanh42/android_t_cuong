package tdc.edu.vn.quanlynhansu.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tdc.edu.vn.quanlynhansu.QuanLyNhanSuActivity;
import tdc.edu.vn.quanlynhansu.R;
import tdc.edu.vn.quanlynhansu.data_models.Person;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Activity activity;
    private int layoutID;
    private ArrayList<Person> personList;
    private OnRecylerItemViewClickListenner recylerItemViewClickListenner;

    public MyRecyclerViewAdapter(Activity activity, int layoutID, ArrayList<Person> personList) {
        this.activity = activity;
        this.layoutID = layoutID;
        this.personList = personList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        CardView view = (CardView) inflater.inflate(viewType, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        //Fil the data to list view item at position
        Person person = personList.get(position);
        if (person.getDegree().equalsIgnoreCase(QuanLyNhanSuActivity.DAIHOC)) {
            viewHolder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.university, activity.getTheme()));
        }
        else if (person.getDegree().equalsIgnoreCase(QuanLyNhanSuActivity.CAODANG)) {
            viewHolder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.college, activity.getTheme()));
        }
        else if (person.getDegree().equalsIgnoreCase(QuanLyNhanSuActivity.TRUNGCAP)) {
            viewHolder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.training, activity.getTheme()));
        }
        else {
            viewHolder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.none, activity.getTheme()));
        }
        viewHolder.lblName.setText(person.getName());
        viewHolder.lblHobbies.setText(person.getHobbies());

        viewHolder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("onBinding", "Called " + position);
                if(recylerItemViewClickListenner != null){
                    recylerItemViewClickListenner.onItemClickListenner(position,viewHolder.itemView);
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    // Definition of view Holder
    protected static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgDegree;
        TextView lblName;
        TextView lblHobbies;
        View.OnClickListener onClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDegree = itemView.findViewById(R.id.imgDegree);
            lblName = itemView.findViewById(R.id.lblName);
            lblHobbies = itemView.findViewById(R.id.lblHobbies);

            imgDegree.setOnClickListener(this);
            lblName.setOnClickListener(this);
            lblHobbies.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Log.d("Onclick", "Call");
            if(onClickListener != null){
                onClickListener.onClick(v);
            }
        }
    }

    public interface OnRecylerItemViewClickListenner{
        public void onItemClickListenner(int position, View cardView);
    }

    public void setRecylerItemViewClickListenner(OnRecylerItemViewClickListenner recylerItemViewClickListenner) {
        this.recylerItemViewClickListenner = recylerItemViewClickListenner;
    }

}
