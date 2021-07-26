package com.example.myapplication2.ViewPager;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    private ViewPagerAdapter adapter;

    //设置界面文件和文字一一对应
    private Fragment[] mfragments = {new TabOneFragment(), new TabTwoFragment(), new TabThreeFragment(), new TabFourFragment()};
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
        //初始化
        tabLayout.getTabAt(ItemWhat);
        for (int i = 1; i < tabLayout.getTabCount();i++){
            View view = LayoutInflater.from(ViewPagerActivity.this).inflate(R.layout.item_view1,null);
//            LinearLayout linearLayout = view.findViewById(R.id.ll_tab1);
            TextView tabText = view.findViewById(R.id.tv_tab1);
            ImageView imageView = view.findViewById(R.id.iv_tab1);

            tabText.setText(mtitles[i]);
            imageView.setImageResource(unimg[i]);

            if (i == ItemWhat){
                imageView.setImageResource(img[i]);
            }

            //设置样式
            tabLayout.getTabAt(i).setCustomView(view);
        }
        //监听
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中时进入，改变样式
                ItemSelect(tab);
                //onTabselected方法里面调用了viewPager的setCurrentItem 所以要想自定义OnTabSelectedListener，也加上mViewPager.setCurrentItem(tab.getPosition())就可以了
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中状态
                ItemNoSelect(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //重新选中
            }
        });
    }
    //tabLayout未选中状态
    private void ItemNoSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        TextView tabText = view.findViewById(R.id.tv_tab1);
        ImageView imageView = view.findViewById(R.id.iv_tab1);
        String stitle = tabText.getText().toString();
        for (int i = 0; i < mtitles.length;i++){
            if (mtitles[i].equals(stitle)){
                imageView.setImageResource(unimg[i]);
            }
        }
    }

    //tabLayout选中状态
    private void ItemSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        TextView tabText = view.findViewById(R.id.tv_tab1);
        ImageView imageView = view.findViewById(R.id.iv_tab1);
        String stitle = tabText.getText().toString();
        for (int i = 0; i < mtitles.length;i++){
            if (mtitles[i].equals(stitle)){
                imageView.setImageResource(img[i]);
            }
        }

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
