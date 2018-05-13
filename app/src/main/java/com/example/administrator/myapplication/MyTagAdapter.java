package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.example.administrator.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/5/13 12:07
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class MyTagAdapter extends CommonNavigatorAdapter {
    private Context mContext;
    private List<String> mData;
    private ViewPager pager;

    public MyTagAdapter(Context mContext, List<String> mData, ViewPager pager) {
        this.mContext = mContext;
        this.mData = mData;
        this.pager = pager;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView view = new SimplePagerTitleView(context);
        view.setText(mData.get(index));
        view.setNormalColor(Color.parseColor("#c8e6c9"));
        view.setSelectedColor(Color.WHITE);
        view.setTextSize(12);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(index);
            }
        });
        return view;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setYOffset(UIUtil.dip2px(context, 3));
        indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
        indicator.setColors(Color.parseColor("#ffffff"));
        return indicator;
    }
}
