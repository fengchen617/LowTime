package com.bawei6.lowtime;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MYViewPageAdapter extends PagerAdapter {

        private List<ImageView> listViews;

        public MYViewPageAdapter(List<ImageView> listViews) {
            this.listViews = listViews;
        }

        @Override
        public int getCount() {
            return listViews == null ? 0 : listViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = listViews.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(listViews.get(position));
        }


}
