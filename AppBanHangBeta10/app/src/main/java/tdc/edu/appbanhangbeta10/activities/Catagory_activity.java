package tdc.edu.appbanhangbeta10.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import tdc.edu.appbanhangbeta10.R;
import tdc.edu.appbanhangbeta10.adapter.MealAdapter;
import tdc.edu.appbanhangbeta10.adapter.PopularAdapter;
import tdc.edu.appbanhangbeta10.databinding.ActivityCatagoryBinding;
import tdc.edu.appbanhangbeta10.viewModel.CategoryViewModel;

public class Catagory_activity extends AppCompatActivity {

    ActivityCatagoryBinding binding;
    CategoryViewModel categoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_catagory);
        initView();
        initData();
    }


    private void initData() {
        int idcate = getIntent().getIntExtra("idcate", 1);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        categoryViewModel.getMealModelMutableLiveData(idcate).observe(this, mealModel -> {
                MealAdapter mealAdapter = new MealAdapter(mealModel.getResult());
                binding.rcCategory.setAdapter(mealAdapter);
        });

    }

    private void initView() {
        binding.rcCategory.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.rcCategory.setLayoutManager(layoutManager);


    }

}