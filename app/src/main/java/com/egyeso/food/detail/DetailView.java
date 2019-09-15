package com.egyeso.food.detail;

import com.egyeso.food.model.MealsEntity;


interface DetailView {

    void showLoading();
    void hideLoading();
    void setMeal(MealsEntity mealsEntity);
    void onErrorLoading(String message);
}
