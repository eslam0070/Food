package com.egyeso.food.main;

import com.egyeso.food.model.CategoriesEntity;
import com.egyeso.food.model.MealsEntity;

import java.util.List;

interface MainView {

    void showLoading();
    void hideLoading();
    void setMeals(List<MealsEntity> mealsEntityList);
    void setCategories(List<CategoriesEntity> categoriesEntityList);
    void onErrorLoading(String message);
}
