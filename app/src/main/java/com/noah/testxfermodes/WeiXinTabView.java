package com.noah.testxfermodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
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
    private Paint mTextPaint;
    private RectF mIconRect;
    private Rect mTextRect;
    private int mTextLeft,mTextTop;
    private Bitmap mIconBitmap;
    private Bitmap mBgBitmap;
    private String mText;
    private int mColor = 0xFF44BF1A;
    private float mTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,10,getResources().getDisplayMetrics());
    private int mAlpha = 255;


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

//        int avaliableWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
//        int avaliableHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - mTextRect.height();
//
//
//        int left = avaliableWidth/2 - mIconBitmap.getWidth()/2;
//        int top = avaliableHeight/2 - mIconBitmap.getHeight()/2;
//
//        mIconRect = new Rect(left,top,left+mIconBitmap.getWidth(),top+mIconBitmap.getHeight());
//
//        mTextLeft = avaliableWidth/2 - mTextRect.width()/2;
//        mTextTop = getMeasuredHeight() - getPaddingBottom();


        int measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight = MeasureSpec.getSize(heightMeasureSpec);


        int avaliableWidth = measuredWidth - getPaddingLeft() - getPaddingRight();
        int avaliableHeight = measuredHeight - getPaddingTop() - getPaddingBottom() - mTextRect.height();

        int iconWidth = Math.min(avaliableWidth,avaliableHeight);

        int left = avaliableWidth/2 - iconWidth/2;
        int top = avaliableHeight/2 - iconWidth/2;

        mIconRect = new RectF(left,top,left+iconWidth,top+iconWidth);
        makeBgBitmap();
        mTextLeft = avaliableWidth/2 - mTextRect.width()/2;
        mTextTop = measuredHeight - getPaddingBottom();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setAlpha(255);
        canvas.drawBitmap(mIconBitmap,null,mIconRect,null);
        setXferMode(canvas);
        canvas.drawText(mText,mTextLeft,mTextTop,mTextPaint);

    }

    private void setXferMode(Canvas canvas) {

        int count = canvas.saveLayer(mIconRect,mPaint);
        mPaint.setColor(mColor);
        mPaint.setAlpha(mAlpha);
        canvas.drawBitmap(mBgBitmap,null,mIconRect,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setAlpha(255);
        canvas.drawBitmap(mIconBitmap,null,mIconRect,mPaint);
        canvas.restoreToCount(count);

    }

    private void makeBgBitmap(){

        mBgBitmap= Bitmap.createBitmap((int)(mIconRect.width()),(int)(mIconRect.height()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mBgBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(mColor);
        canvas.drawRect(0,0,mBgBitmap.getWidth(),mBgBitmap.getHeight(),paint);
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

        mTextRect = new Rect();
        mTextPaint = new Paint();
        mTextPaint.setColor(mColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.getTextBounds(mText,0,mText.length(),mTextRect);


    }

}
