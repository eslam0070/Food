package com.egyeso.food.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Categories implements Serializable {

    @SerializedName("categories")
    private List<CategoriesEntity> categories = null;

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
    }
}
