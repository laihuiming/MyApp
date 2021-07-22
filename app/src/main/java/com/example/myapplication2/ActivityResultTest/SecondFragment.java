package com.example.myapplication2.ActivityResultTest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication2.ActivityResultTest.TableLayoutTest.TableOneFragment;
import com.example.myapplication2.ActivityResultTest.TableLayoutTest.TableTwoFragment;
import com.example.myapplication2.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondFragment extends Fragment {
    private static final String TAG = "SecondFragment";
    private static final String FIRSTPAGE = "0";
    private static final String SECONDPAGE = "1";
    @BindView(R.id.iv_first)
    ImageView ivFirst;
    @BindView(R.id.fg_second)
    Button fgSecond;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private TableOneFragment mTableOneFragment;
    private TableTwoFragment mTableTwoFragment;
    private FragmentManager mFragmentManager;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private String[] tableName= {"第一个页面","第二个页面"};
    private Object TableOneFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
//        secondFragmentInitview();
        initViewPager();
        return view;
    }

    private void initViewPager() {
        mFragmentList.add((Fragment) TableOneFragment);
        mFragmentList.add((Fragment) TableOneFragment);

        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setupWithViewPager(viewpager);
        viewpager.setOffscreenPageLimit(tableName.length);//预加载页面数
        viewpager.setAdapter(new TestTabAdapter(getActivity().getSupportFragmentManager()));
    }


//
//    private void secondFragmentInitview() {
//        mTableOneFragment = new TableOneFragment();
//        mTableTwoFragment = new TableTwoFragment();
//        mFragmentManager = getChildFragmentManager();
//        FragmentTransaction transaction = mFragmentManager.beginTransaction();
//        transaction.add(R.id.fg_tab,mTableOneFragment);
//        transaction.add(R.id.fg_tab,mTableTwoFragment);
//        transaction.show(mTableOneFragment).hide(mTableTwoFragment);
//        transaction.commit();
//    }

    @OnClick(R.id.fg_second)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fg_second:
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
                Log.d(TAG, "Go To SecondActivity---------------");
        }
    }

    public class TestTabAdapter extends FragmentPagerAdapter {

//        public TestTabAdapter(@NonNull FragmentManager fm, int behavior) {
//            super(fm, behavior);
//        }

        public TestTabAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getActivity().getString(Integer.parseInt(tableName[position]));
        }
    }
}
