package com.egyeso.food.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.egyeso.food.R;
import com.egyeso.food.Utils;
import com.egyeso.food.adapter.RecyclerViewHomeAdapter;
import com.egyeso.food.adapter.ViewPagerHeaderAdapter;
import com.egyeso.food.category.CategoryActivity;
import com.egyeso.food.detail.DetailActivity;
import com.egyeso.food.model.CategoriesEntity;
import com.egyeso.food.model.MealsEntity;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_POSITION = "position";
    public static final String EXTRA_DETAIL = "detail";
    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerMeal;
    @BindView(R.id.recyclerCategory)
    RecyclerView recyclerView;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.getMeals();
        presenter.getCategories();
    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.shimmerCategory).setVisibility(View.GONE);
    }

    @Override
    public void setMeals(List<MealsEntity> mealsEntityList) {
        ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(mealsEntityList,this);
        viewPagerMeal.setAdapter(headerAdapter);
        viewPagerMeal.setPadding(20,0,150,0);
        headerAdapter.notifyDataSetChanged();
        headerAdapter.setOnItemClickListener((v, position) -> {
            TextView mealName = v.findViewById(R.id.mealName);
            Intent intent = new Intent(MainActivity.this.getApplicationContext(), DetailActivity.class);
            intent.putExtra(EXTRA_DETAIL, mealName.getText().toString());
            startActivity(intent);
        });
    }

    @Override
    public void setCategories(List<CategoriesEntity> categoriesEntityList) {
        RecyclerViewHomeAdapter recyclerViewHomeAdapter = new RecyclerViewHomeAdapter(categoriesEntityList,this);
        recyclerView.setAdapter(recyclerViewHomeAdapter);
        @SuppressLint("WrongConstant") GridLayoutManager layoutManager = new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerViewHomeAdapter.notifyDataSetChanged();
        recyclerViewHomeAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(this, CategoryActivity.class);
            intent.putExtra(EXTRA_CATEGORY,(Serializable) categoriesEntityList);
            intent.putExtra(EXTRA_POSITION,position);
            startActivity(intent);
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,message,message).show();
    }
}
