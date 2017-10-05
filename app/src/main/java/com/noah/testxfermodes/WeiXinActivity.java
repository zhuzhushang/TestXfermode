package com.noah.testxfermodes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/3 0003.
 */

public class WeiXinActivity extends AppCompatActivity{


    private ViewPager view_pager;
    private WeiXinTabView wx_weixin,wx_contact,wx_faxian,wx_me;
    private List<Fragment> mList;
    private WeiXinPagerAdapter mPagerAdapter;
    private String textArray[] = {"微信","通讯录","发现","我"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weixin);

        viewInit();
        dataInit();

    }

    private void dataInit() {

        mList = new ArrayList<>();
        for (int i = 0; i < textArray.length; i++) {

            WeiXinFragment fragment = new WeiXinFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.WX_FRAGMENT_ARGUMENT,textArray[i]);
            fragment.setArguments(bundle);
            mList.add(fragment);
        }
        mPagerAdapter = new WeiXinPagerAdapter(getSupportFragmentManager(),this,mList);
        view_pager.setAdapter(mPagerAdapter);



    }

    private void viewInit() {


        view_pager = (ViewPager) findViewById(R.id.view_pager);
        wx_weixin = (WeiXinTabView) findViewById(R.id.wx_weixin);
        wx_contact = (WeiXinTabView) findViewById(R.id.wx_contact);
        wx_faxian = (WeiXinTabView) findViewById(R.id.wx_faxian);
        wx_me = (WeiXinTabView) findViewById(R.id.wx_me);

    }


}
