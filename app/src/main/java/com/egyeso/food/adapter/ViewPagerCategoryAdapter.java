package com.egyeso.food.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.egyeso.food.category.CategoryFragment;
import com.egyeso.food.model.CategoriesEntity;

import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    private final List<CategoriesEntity> categories;

    public ViewPagerCategoryAdapter(FragmentManager fm, List<CategoriesEntity> categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int i) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString("EXTRA_DATA_NAME", categories.get(i).getStrcategory());
        args.putString("EXTRA_DATA_DESC", categories.get(i).getStrcategorydescription());
        args.putString("EXTRA_DATA_IMAGE", categories.get(i).getStrcategorythumb());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getStrcategory();
    }
}