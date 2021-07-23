package com.example.myapplication2.ViewPager;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication2.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tv_fvt_one)
    TextView tvFvtOne;
    @BindView(R.id.tv_fvt_two)
    TextView tvFvtTwo;
    @BindView(R.id.tv_fvt_three)
    TextView tvFvtThree;
    @BindView(R.id.tv_fvt_four)
    TextView tvFvtFour;
    private ViewPagerAdapter adapter;

    //设置界面文件和文字一一对应
    private Fragment[] mfragments = {new TabOneFragment(), new TabTwoFragment(), new TabThreeFragment(), new TabThreeFragment()};
    String[] mtitles = {"茶", "啤酒", "果汁", "咖啡"};
//    private List<Fragment> mFragmentList = new ArrayList<>();
    //未选中图片
    private int[] unimg = {R.mipmap.cha_unchecked, R.mipmap.pijiu_unchecked, R.mipmap.guozhi_unchecked, R.mipmap.kafei_unchecked};

    //选中时图片
    private int[] img = {R.mipmap.cha, R.mipmap.pijiu, R.mipmap.guozhi, R.mipmap.kafei};
    //配置默认选中第几项
    private int ItemWhat = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        ItemSelect();
        ItemNoSelect();
    }
    //tabLayout未选中状态
    private void ItemNoSelect(TabLayout.Tab tab) {

    }

    //tabLayout选中状态
    private void ItemSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();

    }

    private void initViewPager() {

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), mtitles,mfragments);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(4);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //使tabLayout与viewpager联动
                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }




}
