package tdc.edu.searchfunction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private ArrayList<Person> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    //Chi lua chon searchView cua android x thoi nha may ma!
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        fakeData();
        anhXa();
    }

    public void fakeData() {
        Person person2 = new Person("Chu dinh hanh", "Ninh thuan", R.drawable.ic_launcher_background);
        Person person3 = new Person("van dinh hanh", "Ninh thuan", R.drawable.ic_launcher_background);
        Person person4 = new Person("Cu dinh hanh", "Ninh thuan", R.drawable.ic_launcher_background);
        Person person5 = new Person("hao dinh hanh", "Ninh thuan", R.drawable.ic_launcher_background);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4);
        arrayList.add(person5);
    }

    public void anhXa() {
        recyclerView = findViewById(R.id.recyclerView);
        //Start setUp
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, R.layout.sear_layout_item, arrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //Start Chinh cai search sang trai
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        //End Chinh cai search sang trai
        //Thuc hien goi filter khi focus vao search area
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myRecyclerViewAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myRecyclerViewAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
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
}