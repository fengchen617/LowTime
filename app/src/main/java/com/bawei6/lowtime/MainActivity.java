package com.bawei6.lowtime;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bawei6.lowtime.ui.weight.MyCustomView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout ll_main;
    private List<ImageView> imageViews;
    private int pagerWidth;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_main = (LinearLayout) findViewById(R.id.activity_main);

        initData();
        mViewPager.setOffscreenPageLimit(3);
        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp = mViewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        mViewPager.setLayoutParams(lp);
        mViewPager.setPageMargin(-50);
        ll_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });

        mViewPager.setPageTransformer(true, new GallyPageTransformer());
        mViewPager.setAdapter(new MYViewPageAdapter(imageViews));
    }

    public class GallyPageTransformer implements ViewPager.PageTransformer {
        private static final float min_scale = 0.85f;

        @Override
        public void transformPage(View page, float position) {
            float scaleFactor = Math.max(min_scale, 1 - Math.abs(position));
            float rotate = 20 * Math.abs(position);
            if (position < -1) {

            } else if (position < 0) {
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setRotationY(rotate);
            } else if (position >= 0 && position < 1) {
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setRotationY(-rotate);
            } else if (position >= 1) {
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setRotationY(-rotate);
            }
        }
    }


    private void initData() {
        imageViews = new ArrayList<>();
        ImageView first = new ImageView(MainActivity.this);
        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.ic_launcher, MainActivity.this));
//        first.setImageResource(R.mipmap.first);
        ImageView second = new ImageView(MainActivity.this);
        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.ic_launcher, MainActivity.this));
//        second.setImageResource(R.mipmap.second);
        ImageView third = new ImageView(MainActivity.this);
        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.ic_launcher, MainActivity.this));
//        third.setImageResource(R.mipmap.third);
        ImageView fourth = new ImageView(MainActivity.this);
//        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fourth,MainActivity.this));
        fourth.setImageResource(R.mipmap.ic_launcher);
        ImageView fifth = new ImageView(MainActivity.this);
        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.ic_launcher, MainActivity.this));
//        fifth.setImageResource(R.mipmap.fifth);
        imageViews.add(first);
        imageViews.add(second);
        imageViews.add(third);
        imageViews.add(fourth);
        imageViews.add(fifth);
    }

}
