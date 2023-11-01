package tdc.edu.whetherforecast.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.whetherforecast.R;
import tdc.edu.whetherforecast.adapter.MyCartRecycleViewAdapter;
import tdc.edu.whetherforecast.adapter.MyDetailRecyclerViewAdapter;
import tdc.edu.whetherforecast.adapter.MySearchRecyclerViewAdapter;
import tdc.edu.whetherforecast.model.Cart;

public class SearchActivity extends AppCompatActivity implements MySearchRecyclerViewAdapter.UserClicListenter {
    private int typeView = 1;
    private static RecyclerView recyclerView;
    private MySearchRecyclerViewAdapter myRecycleViewAdapter;
    private ArrayList<Cart> arrayList = new ArrayList<>();
    private ImageButton btn_select_type_view_search_screen;
    private Button buttonBack;
    private SearchView searchView;
    private boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seartch_layout);
        anhXa();
        chooseTypeView();
        createFakeData();
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);
        btn_select_type_view_search_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventClickTypeView();
            }
        });

        //Catch click button back event
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchActivity.this, "back", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void EventClickTypeView() {
        if (typeView % 2 == 0) {
            typeView = 1;
            btn_select_type_view_search_screen.setBackground(getDrawable(R.drawable.ic_baseline_grid_on_24));
        } else {
            typeView = 2;
            btn_select_type_view_search_screen.setBackground(getDrawable(R.drawable.ic_baseline_view_list_24));
        }
        chooseTypeView();
    }

    public void chooseTypeView() {
        switch (typeView) {
            case 1:
                //Setup
                StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager1);
                if (myRecycleViewAdapter.cartArrayListOnChange != null) {
                    myRecycleViewAdapter = new MySearchRecyclerViewAdapter(this, R.layout.search_layout_item3, myRecycleViewAdapter.cartArrayListOnChange, this::selectedUser);
                } else {
                    myRecycleViewAdapter = new MySearchRecyclerViewAdapter(this, R.layout.search_layout_item3, arrayList, this::selectedUser);
                }
                recyclerView.setAdapter(myRecycleViewAdapter);
                break;
            case 2:
                //Setup
                GridLayoutManager layoutManager2 = new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(layoutManager2);
                if (myRecycleViewAdapter.cartArrayListOnChange != null) {
                    myRecycleViewAdapter = new MySearchRecyclerViewAdapter(this, R.layout.search_layout_item1, myRecycleViewAdapter.cartArrayListOnChange, this::selectedUser);
                } else {
                    myRecycleViewAdapter = new MySearchRecyclerViewAdapter(this, R.layout.search_layout_item1, arrayList, this::selectedUser);
                }
                recyclerView.setAdapter(myRecycleViewAdapter);
                break;
        }
        flag = true;
    }


    public void anhXa() {
        buttonBack = findViewById(R.id.btn_back_search_screen);
        btn_select_type_view_search_screen = findViewById(R.id.btn_select_type_view_search_screen);
        recyclerView = findViewById(R.id.recyclerView_search_screen);
    }

    public void createFakeData() {
        Cart cart = new Cart("ca chien1", 12, 9999, R.drawable.anh_nhopng, 1);
        Cart cart2 = new Cart("ca chien2", 12, 9999, R.drawable.food4png, 1);
        Cart cart3 = new Cart("ca chien3", 12, 9999, R.drawable.img, 1);
        arrayList.add(cart2);
        arrayList.add(cart3);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
    }


    // Display menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        //End Chinh cai search sang trai
        //Thuc hien goi filter khi focus vao search area
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myRecycleViewAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (flag == true) {
                    binData();
                    flag = false;
                }
                myRecycleViewAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    public void binData() {
        myRecycleViewAdapter = new MySearchRecyclerViewAdapter(this, R.layout.search_layout_item3, arrayList, this::selectedUser);
        recyclerView.setAdapter(myRecycleViewAdapter);
    }

    // Xử lý sư kiện ấn nút backPress buttbutton
    /*
     * Đây là một phương thức được ghi đè
     * trong Android để xử lý sự kiện khi
     * người dùng bấm nút "Back" trên thiết bị.
     * Trong phương thức này, nếu thanh tìm kiếm (searchView)
     *  đang mở rộng, nó sẽ được thu nhỏ lại. Nếu không,
     *  phương thức sẽ gọi lại phương thức onBackPressed()
     *  của lớp cha để xử lý sự kiện "Back" mặc định.
     * */
    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void selectedUser(Cart userModel) {
        Toast.makeText(this, "click!" + userModel.getName(), Toast.LENGTH_SHORT).show();
    }
}