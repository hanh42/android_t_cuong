package vn.tdc.edu.fooddelivery.activities;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import tdc.edu.doanbeta1.R;
import vn.tdc.edu.fooddelivery.activities.admin.CategoryManagementActivity;
import vn.tdc.edu.fooddelivery.activities.admin.OrderManagementActivity;
import vn.tdc.edu.fooddelivery.activities.admin.ProductManagementActivity;
import vn.tdc.edu.fooddelivery.activities.admin.UserManagementActivity;
import vn.tdc.edu.fooddelivery.fragments.AbstractFragment;
import vn.tdc.edu.fooddelivery.fragments.CartFragment;
import vn.tdc.edu.fooddelivery.fragments.HomeFragment;
import vn.tdc.edu.fooddelivery.fragments.NotificationFragment;
import vn.tdc.edu.fooddelivery.fragments.ProfileFragment;

public class MainActivity extends AbstractActivity {
    NavigationView navigation;
    BottomNavigationView bottomNavigation;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    private AbstractFragment fragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        navigation = findViewById(R.id.navigation);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_navigation);

        setFragment(HomeFragment.class);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        setFragment(HomeFragment.class);
                        break;
                    case R.id.menu_cart:
                        setFragment(CartFragment.class);
                        break;
                    case R.id.menu_notification:
                        setFragment(NotificationFragment.class);
                        break;
                    case R.id.menu_profile:
                        setFragment(ProfileFragment.class);
                        break;
                    default:
                        setFragment(HomeFragment.class);
                        break;
                }
                return true;
            }
        });

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_product_management:
                        switchActivity( ProductManagementActivity.class, "Quản lý hàng hoá");
                        break;
                    case R.id.nav_order_management:
                        switchActivity(OrderManagementActivity.class, "Quản lý đơn hàng");
                        break;
                    case R.id.nav_user_management:
                        switchActivity( UserManagementActivity.class, "Quản lý người dùng");
                        break;
                    case R.id.nav_category_management:
                        switchActivity(CategoryManagementActivity.class, "Quản lý danh mục sản phẩm");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void setFragment(Class tClass) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, tClass, null)
                .setReorderingAllowed(true)
                .commit();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}