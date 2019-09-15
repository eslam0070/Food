package com.egyeso.food.category;

import com.egyeso.food.model.MealsEntity;

import java.util.List;

interface CategoryView {

    void showLoading();
    void hideLoading();
    void setMeals(List<MealsEntity> meals);
    void onErrorLoading(String message);
}
