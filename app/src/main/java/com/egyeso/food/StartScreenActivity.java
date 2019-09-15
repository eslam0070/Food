package com.egyeso.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import com.egyeso.food.main.MainActivity;
import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartScreenActivity extends AppCompatActivity {

    @BindView(R.id.startButton)
    Button button;
    @BindView(R.id.happy)
    TextView happy;
    private ShowcaseView.Builder showcaseView;
    private final int SHOWCASEVIEW_ID = 28;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        ButterKnife.bind(this);
        button.setOnClickListener(view -> {
            startActivity(new Intent(StartScreenActivity.this, MainActivity.class));
            finish();
        });
        showCase();
    }
    private void showCase(){
        showcaseView = new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setTarget(new ViewTarget(R.id.startButton,this))
                .setContentTitle("Get Started")
                .setContentText("Continue To Application..")
                .setStyle(R.style.ShowCaseViewStyle)
                .singleShot(SHOWCASEVIEW_ID)
        .setShowcaseEventListener(new OnShowcaseEventListener() {
            @Override
            public void onShowcaseViewHide(ShowcaseView showcaseView) {

            }

            @Override
            public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

            }

            @Override
            public void onShowcaseViewShow(ShowcaseView showcaseView) {

            }

            @Override
            public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

            }
        });
        showcaseView.build();
    }
}
