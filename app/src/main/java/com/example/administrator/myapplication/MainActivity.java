package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MagicIndicator mMagicIndicator2;
    private ViewPager mViewpage;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 10;
        list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            list.add("小明" + i);
        }
        initView();
        initIndicator2();
    }

    private void initIndicator2() {
        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator2);
        magicIndicator.setBackgroundColor(Color.parseColor("#00c853"));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setScrollPivotX(0.25f);
        MyTagAdapter adapter = new MyTagAdapter(this, list, mViewpage);
        magicIndicator.setNavigator(commonNavigator);
        commonNavigator.setAdapter(adapter);
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            PagerFragment fragment = PagerFragment.newInstance("", "");
            fragments.add(fragment);

        }
        MyTagPagerAdapter pagerAdapter = new MyTagPagerAdapter(getSupportFragmentManager(), this, fragments);
        mViewpage.setAdapter(pagerAdapter);
        if (list.size()<2){
            magicIndicator.setVisibility(View.GONE);
        }
        ViewPagerHelper.bind(magicIndicator, mViewpage);


    }

    private void initView() {
        mMagicIndicator2 = (MagicIndicator) findViewById(R.id.magic_indicator2);
        mViewpage = (ViewPager) findViewById(R.id.viewpage);
    }
}
