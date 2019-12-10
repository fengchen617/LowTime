package com.bawei6.lowtime.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei6.lowtime.R;
import com.bumptech.glide.Glide;

/**
 * name:fengchen
 * time:19.12.10
 * 欢迎界面——选择  年   月  日
 */

public class Welcome_Select_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView welcome_select_img;
    private Button w_s_b_year;
    private Button w_s_b_mounth;
    private Button w_s_b_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__select_);
        initView();
    }

    private void initView() {
        welcome_select_img = (ImageView) findViewById(R.id.welcome_select_img);
        Glide.with(this).load("http://hbimg.b0.upaiyun.com/9852feef26dcba3d807282aa5dff561b1e223de85b027-Tzv0x0_fw658").into(welcome_select_img);

        w_s_b_year = (Button) findViewById(R.id.w_s_b_year);
        w_s_b_year.setOnClickListener(this);
        w_s_b_mounth = (Button) findViewById(R.id.w_s_b_mounth);
        w_s_b_mounth.setOnClickListener(this);
        w_s_b_day = (Button) findViewById(R.id.w_s_b_day);
        w_s_b_day.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.w_s_b_year:

                break;
            case R.id.w_s_b_mounth:

                break;
            case R.id.w_s_b_day:

                break;
        }
    }
}
