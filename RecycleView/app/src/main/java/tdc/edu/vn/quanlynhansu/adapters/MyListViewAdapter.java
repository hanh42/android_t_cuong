package tdc.edu.vn.quanlynhansu.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.quanlynhansu.QuanLyNhanSuActivity;
import tdc.edu.vn.quanlynhansu.R;
import tdc.edu.vn.quanlynhansu.data_models.Person;

public class MyListViewAdapter extends ArrayAdapter<Person> {
    private Activity activity;
    private int layoutID;
    private ArrayList<Person> personList;

    public MyListViewAdapter(Activity activity, int layoutID, ArrayList<Person> personList) {
        super(activity, layoutID, personList);

        this.activity = activity;
        this.layoutID = layoutID;
        this.personList = personList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        MyViewHolder holder = null;

        if (convertView == null) { // Create new list view item
            view = activity.getLayoutInflater().inflate(layoutID, parent, false);
            holder = new MyViewHolder();

            holder.imgDegree = view.findViewById(R.id.imgDegree);
            holder.lblName = view.findViewById(R.id.lblName);
            holder.lblHobbies = view.findViewById(R.id.lblHobbies);
            // Binding the view holder with the view item
            view.setTag(holder);
        }
        else {  // Reuse the list view item
            view = convertView;
            holder = (MyViewHolder) view.getTag();
        }
        //Fil the data to list view item at position
        Person person = personList.get(position);
        if (person.getDegree().equalsIgnoreCase(QuanLyNhanSuActivity.DAIHOC)) {
            holder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.university, activity.getTheme()));
        }
        else if (person.getDegree().equalsIgnoreCase(QuanLyNhanSuActivity.CAODANG)) {
            holder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.college, activity.getTheme()));
        }
        else if (person.getDegree().equalsIgnoreCase(QuanLyNhanSuActivity.TRUNGCAP)) {
            holder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.training, activity.getTheme()));
        }
        else {
            holder.imgDegree.setImageDrawable(activity.getResources().getDrawable(R.mipmap.none, activity.getTheme()));
        }
        holder.lblName.setText(person.getName());
        holder.lblHobbies.setText(person.getHobbies());
        return view;
    }

    //Create ViewHolder Class
    private static class MyViewHolder {
        ImageView imgDegree;
        TextView lblName;
        TextView lblHobbies;
    }
}
