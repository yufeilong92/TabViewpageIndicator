package com.example.administrator.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.example.administrator.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/5/13 12:15
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class MyTagPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<Fragment> mData;

    public MyTagPagerAdapter(FragmentManager fm, Context mContext, List<Fragment> mData) {
        super(fm);
        this.mContext = mContext;
        this.mData = mData;
    }

    public MyTagPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
