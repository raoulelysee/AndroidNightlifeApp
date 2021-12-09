package com.example.admin.mon1ernightlife.ProfileUserMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.admin.mon1ernightlife.R;

public class Profile extends FragmentActivity {

    private static final int NUMBER_OF_PAGES = 3;

    private ViewPager swipingPages;

    private PagerAdapter pageInTheViewPagerWidget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        swipingPages = (ViewPager)findViewById(R.id.viewpager);
        pageInTheViewPagerWidget = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        swipingPages.setAdapter(pageInTheViewPagerWidget);


    }

    @Override
    public void onBackPressed(){
        if(swipingPages.getCurrentItem() == 0){
            // If back is press on the first Fragment return to previous Activity
            super.onBackPressed();
        }else {

            swipingPages.setCurrentItem(swipingPages.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that contains 3 ScreenSlidePageAdapter in sequence
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fragManage) {
            super(fragManage);

        }

        public CharSequence getPageTitle(int position) {
            String titlePosition = null;
            switch (position){
                case 0:
                    titlePosition = "My details";
                    break;
                case 1:
                    titlePosition = "My Preferences";
                    break;
                case 2:
                    titlePosition = "My settings";
                    break;
            }
            return titlePosition;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment Frag = null;
            switch (position){
                case 0:
                    Frag = new ScreenSlideFirstFragment();
                    break;
                case 1:
                    Frag = new ScreenSlideSecondFragment();
                    break;
                case 2:
                    Frag = new ScreenSlideThirdFragment();
                    break;
            }
            return Frag;
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }
    }
}
