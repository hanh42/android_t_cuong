package tdc.edu.appbanhangbeta10.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import tdc.edu.appbanhangbeta10.R;
import tdc.edu.appbanhangbeta10.adapter.CategoryAdapter;
import tdc.edu.appbanhangbeta10.adapter.PopularAdapter;
import tdc.edu.appbanhangbeta10.databinding.ActivityHomeBinding;
import tdc.edu.appbanhangbeta10.listenter.CategoryListener;
import tdc.edu.appbanhangbeta10.models.Category;
import tdc.edu.appbanhangbeta10.models.CategoryModel;
import tdc.edu.appbanhangbeta10.models.MealModel;
import tdc.edu.appbanhangbeta10.models.Meals;
import tdc.edu.appbanhangbeta10.viewModel.HomeViewModel;

public class HomeActivity extends AppCompatActivity implements CategoryListener {
    Handler handler;
    HomeViewModel homeViewModel;
    ActivityHomeBinding binding;
    ProgressBar progressBar, progressBar2;
    PopularAdapter popularAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        anhXa();
        initView();
        initData();
    }

    public void anhXa() {
        progressBar = findViewById(R.id.ProgressBar_ID_HomePage);
        progressBar2 = findViewById(R.id.ProgressBar2_ID_HomePage);
    }

    private void initView() {
        binding.rcDssp.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rcDssp.setLayoutManager(layoutManager);

        binding.rcPopular.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this, 3);
        binding.rcPopular.setLayoutManager(layoutManager1);
    }

    private void initData() {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.categoryModelMutableLiveData().observe(this, categoryModel -> {
            if (categoryModel.isSucces()) {
                CategoryAdapter adapter = new CategoryAdapter(categoryModel.getResult(), this);
                binding.rcDssp.setAdapter(adapter);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }, 2000);
            } else {
                Toast.makeText(this, "khong the lay du lieu! ", Toast.LENGTH_SHORT).show();
            }
        });

        homeViewModel.mealModelMutableLiveData(2).observe(this, mealModel -> {
            popularAdapter = new PopularAdapter(mealModel.getResult());
            binding.rcPopular.setAdapter(popularAdapter);
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar2.setVisibility(View.INVISIBLE);
                }
            }, 2000);

        });

    }

    //gui du lieu qua
    @Override
    public void onCategoryClick(Category category) {
        Intent intent = new Intent(getApplicationContext(), Catagory_activity.class);
        intent.putExtra("idcate", category.getId());
        startActivity(intent);
    }
}