package com.example.myapplication2.ViewPager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles;
    private Fragment[] mfragment;
    public ViewPagerAdapter(@NonNull FragmentManager fm,String[] mTitles,Fragment[] mfragment) {
        super(fm);
        this.mTitles = mTitles;
        this.mfragment = mfragment;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        if (position==0) {
//            return new TabOneFragment();
//        }if (position==1) {
//            return new TabTwoFragment();
//        }if (position==2) {
//            return new TabThreeFragment();
//        }if (position==3){
//            return new TabFourFragment();
//        }
//        return new TabOneFragment();//默认返回第一个界面
        return mfragment[position];
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
