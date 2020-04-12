package com.example.drumdrum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreenActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animFadeIn;
    LinearLayout linearLayout;
    TextView my_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        my_name = findViewById(R.id.my_name);


        animate();

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_fade_in);
        animFadeIn.setAnimationListener(this);
        linearLayout = findViewById(R.id.splash_layout);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.startAnimation(animFadeIn);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }


    @Override
    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    public void animate() {

        final ImageView imageView = findViewById(R.id.splash_icon);
        final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        final Animation animation_2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anti_rotate);

        imageView.startAnimation(animation_2);


        animation_2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                my_name.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(animation_1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        animation_1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                startActivity( new Intent( SplashScreenActivity.this, MainActivity.class ) );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
