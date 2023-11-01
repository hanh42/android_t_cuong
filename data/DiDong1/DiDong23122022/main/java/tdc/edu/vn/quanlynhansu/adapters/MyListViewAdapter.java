package tdc.edu.vn.quanlynhansu.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.quanlynhansu.MainActivity;
import tdc.edu.vn.quanlynhansu.Persion;
import tdc.edu.vn.quanlynhansu.R;

public class MyListViewAdapter extends ArrayAdapter<Persion> {
    private Activity activity ;
    private int layoutId;
    private ArrayList<Persion> listPersion;
    public MyListViewAdapter(Activity activity, int layoutId, ArrayList<Persion> listPersion) {
        super(activity, layoutId, listPersion);
        this.activity = activity;
        this.layoutId = layoutId;
        this.listPersion = listPersion;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view = null;
        view = activity.getLayoutInflater().inflate(layoutId,parent,false);
        Persion persion = listPersion.get(position);
        ImageView imgView = view.findViewById(R.id.imgDegree);
        TextView lblName = view.findViewById(R.id.lblName);
        TextView lblHoppies = view.findViewById(R.id.lblHoppies);
        if(persion.getBangCap().equalsIgnoreCase(MainActivity.DAIHOC)){
            imgView.setImageDrawable(activity.getResources().getDrawable(R.mipmap.university,activity.getTheme()));
        }
        else if(persion.getBangCap().equalsIgnoreCase(MainActivity.CAODANG)){
            imgView.setImageDrawable(activity.getResources().getDrawable(R.mipmap.college,activity.getTheme()));
        }
        else if(persion.getBangCap().equalsIgnoreCase(MainActivity.TRUNGCAP)){
            imgView.setImageDrawable(activity.getResources().getDrawable(R.mipmap.training,activity.getTheme()));
        }
        else {
            imgView.setImageDrawable(activity.getResources().getDrawable(R.mipmap.none,activity.getTheme()));
        }
        lblName.setText(persion.getHoVaTen());
        lblHoppies.setText(persion.getSoThich());
        return view;
    }
}
