package com.noah.testxfermodes;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/5 0005.
 */

public class WeiXinPagerAdapter extends FragmentPagerAdapter{

    private Context context;
    private List<Fragment> mList;

    public WeiXinPagerAdapter(FragmentManager fm,Context context,List<Fragment> list) {
        super(fm);
        this.context = context;
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList != null ? mList.get(position) : null;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }
}
