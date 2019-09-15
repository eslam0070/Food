package com.egyeso.food.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.egyeso.food.R;
import com.egyeso.food.Utils;
import com.egyeso.food.model.MealsEntity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.egyeso.food.main.MainActivity.EXTRA_DETAIL;

public class DetailActivity extends AppCompatActivity implements DetailView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.mealThumb)
    ImageView mealThumb;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.country)
    TextView country;
    @BindView(R.id.instructions)
    TextView instructions;
    @BindView(R.id.ingredient)
    TextView ingredients;
    @BindView(R.id.measure)
    TextView measures;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.youtube)
    TextView youtube;
    @BindView(R.id.source)
    TextView source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String mealName = intent.getStringExtra(EXTRA_DETAIL);

        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getMealById(mealName);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setMeal(MealsEntity mealsEntity) {
        Picasso.get().load(mealsEntity.getStrmealthumb()).into(mealThumb);
        collapsingToolbarLayout.setTitle(mealsEntity.getStrmeal());
        category.setText(mealsEntity.getStrcategory());
        country.setText(mealsEntity.getStrarea());
        instructions.setText(mealsEntity.getStrinstructions());
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //===

        if (!mealsEntity.getStringredient1().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient1());
        }
        if (!mealsEntity.getStringredient2().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient2());
        }
        if (!mealsEntity.getStringredient3().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient3());
        }
        if (!mealsEntity.getStringredient4().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient4());
        }
        if (!mealsEntity.getStringredient5().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient5());
        }
        if (!mealsEntity.getStringredient6().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient6());
        }
        if (!mealsEntity.getStringredient7().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient7());
        }
        if (!mealsEntity.getStringredient8().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient8());
        }
        if (!mealsEntity.getStringredient9().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient9());
        }
        if (!mealsEntity.getStringredient10().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient10());
        }
        if (!mealsEntity.getStringredient11().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient11());
        }
        if (!mealsEntity.getStringredient12().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient12());
        }
        if (!mealsEntity.getStringredient13().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient13());
        }
        if (!mealsEntity.getStringredient14().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient14());
        }
        if (!mealsEntity.getStringredient15().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient15());
        }
        if (!mealsEntity.getStringredient16().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient16());
        }
        if (!mealsEntity.getStringredient17().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient17());
        }
        if (!mealsEntity.getStringredient18().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient18());
        }
        if (!mealsEntity.getStringredient19().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient19());
        }
        if (!mealsEntity.getStringredient20().isEmpty()) {
            ingredients.append("\n \u2022 " + mealsEntity.getStringredient20());
        }

        if (!mealsEntity.getStringredient1().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient1().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient1());
        }
        if (!mealsEntity.getStringredient2().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient2().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient2());
        }
        if (!mealsEntity.getStringredient3().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient3().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient3());
        }
        if (!mealsEntity.getStringredient4().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient4().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient4());
        }
        if (!mealsEntity.getStringredient5().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient5().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient5());
        }
        if (!mealsEntity.getStringredient6().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient6().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient6());
        }
        if (!mealsEntity.getStringredient7().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient7().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient7());
        }
        if (!mealsEntity.getStringredient8().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient8().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient8());
        }
        if (!mealsEntity.getStringredient9().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient9().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient9());
        }
        if (!mealsEntity.getStringredient10().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient10().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient10());
        }
        if (!mealsEntity.getStringredient11().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient11().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient11());
        }
        if (!mealsEntity.getStringredient12().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient12().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient12());
        }
        if (!mealsEntity.getStringredient13().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient13().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient13());
        }
        if (!mealsEntity.getStringredient14().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient14().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient14());
        }
        if (!mealsEntity.getStringredient15().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient15().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient15());
        }
        if (!mealsEntity.getStringredient16().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient16().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient16());
        }
        if (!mealsEntity.getStringredient17().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient17().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient17());
        }
        if (!mealsEntity.getStringredient18().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient18().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient18());
        }
        if (!mealsEntity.getStringredient19().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient19().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient19());
        }
        if (!mealsEntity.getStringredient20().isEmpty() && !Character.isWhitespace(mealsEntity.getStringredient20().charAt(0))) {
            measures.append("\n : " + mealsEntity.getStringredient20());
        }


        youtube.setOnClickListener(v -> {
            Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
            intentYoutube.setData(Uri.parse(mealsEntity.getStryoutube()));
            DetailActivity.this.startActivity(intentYoutube);
        });

        source.setOnClickListener(v -> {
            Intent intentSource = new Intent(Intent.ACTION_VIEW);
            intentSource.setData(Uri.parse(mealsEntity.getStrsource()));
            DetailActivity.this.startActivity(intentSource);
        });
    }


    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Error", message);
    }
}
