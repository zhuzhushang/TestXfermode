package com.noah.testxfermodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Administrator on 2017/10/3 0003.
 */

public class WeiXinTabView extends View{

    private Paint mPaint;
    private Bitmap mIconBitmap;
    private String mText;
    private int mColor = 0xFF44BF1A;
    private float mTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,10,getResources().getDisplayMetrics());


    public WeiXinTabView(Context context) {
        this(context,null);
    }

    public WeiXinTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public WeiXinTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        initAttrs(context,attrs);
        initOther();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



    }

    private void initOther() {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);

    }

    private void initAttrs(Context context,AttributeSet attrs) {

        TypedArray typeArray = context.obtainStyledAttributes(attrs,R.styleable.weixin_tab);

        for (int i = 0; i < typeArray.getIndexCount(); i++) {

            int index = typeArray.getIndex(i);
            switch (index){

                case R.styleable.weixin_tab_icon:

                    BitmapDrawable bitmapDrawable = (BitmapDrawable) typeArray.getDrawable(index);
                    mIconBitmap = bitmapDrawable.getBitmap();

                    break;
                case R.styleable.weixin_tab_text:

                    mText = typeArray.getString(index);

                    break;
                case R.styleable.weixin_tab_color:

                    mColor = typeArray.getColor(index,mColor);

                    break;
                case R.styleable.weixin_tab_textSize:

                    mTextSize =  typeArray.getDimension(index,mTextSize);

                    break;
            }
        }

        typeArray.recycle();
    }

}
