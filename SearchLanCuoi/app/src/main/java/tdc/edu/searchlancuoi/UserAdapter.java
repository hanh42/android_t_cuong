package tdc.edu.searchlancuoi;

import android.content.Context;
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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterVH> implements Filterable {
    //1
    public List<UserModel> userModelsList = new ArrayList<>();
    //4
    public List<UserModel> getUserModelFilter = new ArrayList<>();
    //2
    public Context context;
    //3
    public UserClicListenter userClicListenter;

    public UserAdapter(List<UserModel> userModels, Context context, UserClicListenter userClicListenter) {
        this.userModelsList = userModels;
        this.context = context;
        this.userClicListenter = userClicListenter;
        //-----//
        this.getUserModelFilter = userModels;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.values = getUserModelFilter;
                    filterResults.count = getUserModelFilter.size();
                } else {
                    String searchStr = constraint.toString().toLowerCase();
                    List<UserModel> userModels = new ArrayList<>();
                    for(UserModel userModel:getUserModelFilter){
                        if(userModel.getFirsrName().toLowerCase().contains(searchStr)){
                            userModels.add(userModel);
                        }
                    }
                    filterResults.values =  userModels;
                    filterResults.count = userModels.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults Results) {
                    userModelsList = (List<UserModel>) Results.values;
                    notifyDataSetChanged();
            }
        };
        return filter;
    }

    public interface UserClicListenter {
        void selectedUser(UserModel userModel);
    }


    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_user, parent, false);
        return new UserAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        UserModel userModel = userModelsList.get(position);
        String name = userModel.getFirsrName() + " " + userModel.getLastName();
        String phone = userModel.getPhone();
        //--------------------------//
        holder.tvPhone.setText(phone);
        holder.tvName.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicListenter.selectedUser(userModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userModelsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row_user;
    }

    public static class UserAdapterVH extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvPhone;

        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }
    }

}
