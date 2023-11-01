package tdc.edu.vn.quanlynhansu.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.quanlynhansu.QuanLyNhanSuActivity;
import tdc.edu.vn.quanlynhansu.R;
import tdc.edu.vn.quanlynhansu.data_models.Person;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Activity activity;
    private int layoutID;
    private ArrayList<Person> personList;

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
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        // fill the data to list view item at positon
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
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    // Definition of View Holder
    protected static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDegree;
        TextView lblName;
        TextView lblHobbies;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDegree = itemView.findViewById(R.id.imgDegree);
            lblName = itemView.findViewById(R.id.lblName);
            lblHobbies = itemView.findViewById(R.id.lblHobbies);



        }
    }
}
