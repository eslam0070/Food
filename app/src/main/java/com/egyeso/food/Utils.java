package com.egyeso.food;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.egyeso.food.api.FoodApi;
import com.egyeso.food.api.FoodClient;

public class Utils {
    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
