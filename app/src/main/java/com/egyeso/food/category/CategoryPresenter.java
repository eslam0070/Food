package com.egyeso.food.category;

import android.support.annotation.NonNull;

import com.egyeso.food.Utils;
import com.egyeso.food.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class CategoryPresenter {

    private final CategoryView view;

    CategoryPresenter(CategoryView view) {
        this.view = view;
    }

    void getMealByCategory(String category) {
        view.showLoading();
        Call<Meals> call = Utils.getApi().getMealByCategory(category);
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                if (response.isSuccessful() && response.body() != null){
                    view.hideLoading();
                    view.setMeals(response.body().getMeals());
                }else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getMessage());
            }
        });
    }
}
