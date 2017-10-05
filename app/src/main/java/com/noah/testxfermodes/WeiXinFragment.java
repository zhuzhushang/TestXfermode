package com.noah.testxfermodes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/3 0003.
 */

public class WeiXinFragment extends Fragment{


    private int colorArray[] = {0x8fff0000,0x8f00ff00,0x8f0000ff,0xffffff00};
    private String textArray[] = {"微信","通讯录","发现","我"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String text = getArguments().getString(Constants.WX_FRAGMENT_ARGUMENT);
        TextView textView = new TextView(getActivity());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,26);

        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i].equals(text)){
                textView.setBackgroundColor(colorArray[i]);
                break;
            }
        }
        textView.setText(text);


        return textView;
    }
}
