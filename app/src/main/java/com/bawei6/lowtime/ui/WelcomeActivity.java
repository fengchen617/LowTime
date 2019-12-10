package com.bawei6.lowtime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei6.lowtime.R;

/**
 * name:fengchen
 * time:19.12.10
 *       欢迎界面
 */
public class WelcomeActivity extends AppCompatActivity {

    private TextView welcome_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        welcome_text = (TextView) findViewById(R.id.welcome_text);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.welcome_animation);
        welcome_text.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(WelcomeActivity.this, Welcome_Select_Activity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
