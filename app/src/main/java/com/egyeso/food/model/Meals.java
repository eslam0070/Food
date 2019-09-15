package com.egyeso.food.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Meals {

    @SerializedName("meals")
    private List<MealsEntity> meals = null;

    public List<MealsEntity> getMeals() {
        return meals;
    }

    public void setMeals(List<MealsEntity> meals) {
        this.meals = meals;
    }
}
