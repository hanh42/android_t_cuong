package tdc.edu.onlysearch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserAdaptere extends RecyclerView.Adapter<UserAdaptere.UserAdapterVn> implements Filterable {
   //1
    public List<UserModel> userModellist = new ArrayList<>();
    public List<UserModel> getUserModellistFilter = new ArrayList<>();
    //2
    public Context context;
    //Bat su kien click
    private UserClickListenner userClickListenner;


    public UserAdaptere(List<UserModel> userModellist, Context context, UserClickListenner userClickListenner) {
        this.userModellist = userModellist;
        this.context = context;
        this.userClickListenner = userClickListenner;
        this.getUserModellistFilter = userModellist;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                Log.d("TAG", "performFiltering: "+charSequence.toString());
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.values = getUserModellistFilter;
                    filterResults.count = getUserModellistFilter.size();
                } else {
                    String searchStr = charSequence.toString().toLowerCase();
                    List<UserModel> userModels = new ArrayList<>();
                    for (UserModel userModel : getUserModellistFilter) {
                        if (userModel.getFirstName().toLowerCase().contains(searchStr) ||
                                userModel.getLastName().toLowerCase().contains(searchStr)) {
                            userModels.add(userModel);
                        }
                    }
                    filterResults.values = userModels;
                    filterResults.count = userModels.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                userModellist = (List<UserModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return null;
    }

    public interface UserClickListenner {
        void selectedUser(UserModel userModel);
    }


    @NonNull
    @Override
    public UserAdapterVn onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_user, parent, false);
        return new UserAdapterVn(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVn holder, int position) {
        UserModel userModel = userModellist.get(position);
        String firstName = userModel.getFirstName();
        String lastName = userModel.getLastName();
        String userPhone = userModel.getUserPhone();
        String userName = firstName + lastName;

        holder.userPhone.setText(userPhone);
        holder.userName.setText(userName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClickListenner.selectedUser(userModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userModellist.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row_user;
    }

    public static class UserAdapterVn extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView userPhone;

        public UserAdapterVn(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.tvName);
            userPhone = itemView.findViewById(R.id.tvPhone);
        }
    }
}
