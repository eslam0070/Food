package com.egyeso.food.detail;

import android.support.annotation.NonNull;

import com.egyeso.food.Utils;
import com.egyeso.food.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class DetailPresenter {
    private final DetailView view;

    DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getMealById(String mealName) {

        view.showLoading();

        Utils.getApi().getMealByName(mealName)
                .enqueue(new Callback<Meals>() {
                    @Override
                    public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                        view.hideLoading();
                        if (response.isSuccessful() && response.body() != null) {
                            view.setMeal(response.body().getMeals().get(0));

                        } else {
                            view.onErrorLoading(response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                        view.hideLoading();
                        view.onErrorLoading(t.getLocalizedMessage());
                    }
                });
    }
}
