package tdc.edu.onlysearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserAdaptere.UserClickListenner {
    RecyclerView rvUsers;
    UserAdaptere userAdaptere;
    List<UserModel> userModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvUsers = findViewById(R.id.rvUsers);
        setData();
        prepareRecyclerView();
    }

    public void setData() {
        userModelList.add(new UserModel("hanh1", "chu", "0988244510"));
        userModelList.add(new UserModel("hanh2", "chu", "0988244510"));
        userModelList.add(new UserModel("hanh3", "chu", "0988244510"));
    }

    public void prepareRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUsers.setLayoutManager(linearLayoutManager);
        preAdapter();
    }

    public void preAdapter() {
        userAdaptere = new UserAdaptere(userModelList, this, this::selectedUser);
        rvUsers.setAdapter(userAdaptere);
    }

    @Override
    public void selectedUser(UserModel userModel) {
        Toast.makeText(this, "click" + userModel.getFirstName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.searchView) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String searchStr = s;
                userAdaptere.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}