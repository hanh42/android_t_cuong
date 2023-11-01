package tdc.edu.searchfunction;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements Filterable {
    private Activity activity;
    private int layout_ID;
    private ArrayList<Person> arrayList;
    private ArrayList<Person> arrayListOld;


    public MyRecyclerViewAdapter(Activity activity, int layout_ID, ArrayList<Person> arrayList) {
        this.activity = activity;
        this.layout_ID = layout_ID;
        this.arrayList = arrayList;
        arrayListOld = arrayList;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        CardView cardView = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        Person person = arrayList.get(position);
        holder.imgV.setImageDrawable(activity.getResources().getDrawable(person.getImg(), activity.getTheme()));
        holder.txt_name.setText(person.getName());
        holder.txt_address.setText(person.getAddress());
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
        private ImageView imgV;
        private TextView txt_name;
        private TextView txt_address;
        private View.OnClickListener onClickListener;

        public MyViewHolder(@NonNull View v) {
            super(v);
            imgV = v.findViewById(R.id.imgV);
            txt_name = v.findViewById(R.id.txt_name);
            txt_address = v.findViewById(R.id.txt_address);
            //Catch event
            imgV.setOnClickListener(this);
            txt_name.setOnClickListener(this);
            txt_address.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    // Phan thuc hien tim kiem va xuat len man hinh
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                // Lúc đầu khi ta chưa điền giá trị thì nó có giá trị bằng giá trị của tất cả các giá trị có trong mảng gốc
                if (strSearch.isEmpty()) {
                    arrayList = arrayListOld;
                } else {
                    ArrayList<Person> list = new ArrayList<>();
                    for (Person user : arrayListOld) {
                        if (user.getName().toLowerCase().contains(strSearch.toLowerCase())) {
                            list.add(user);
                        }
                    }
                    arrayList = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                arrayList = (ArrayList<Person>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
