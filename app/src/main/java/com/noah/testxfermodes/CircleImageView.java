package com.noah.testxfermodes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/9/19 0019.
 */

public class CircleImageView extends View{

    private Bitmap mBitmap;
    private Paint mPaint;
    Context context;




    public CircleImageView(Context context) {
        this(context,null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        init(context);
    }


    public void init(Context context){

        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.coershen);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        int width = mBitmap.getWidth();
//        int height = mBitmap.getHeight();
//        Paint p = new Paint();
//        Bitmap b = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
//        Canvas c = new Canvas(b);
//        p.setColor(Color.BLUE);
//        c.drawCircle(100,100,100,p);
//
//        canvas.drawBitmap(b,0,0,p);
//
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawBitmap(mBitmap,0,0,mPaint);


        Rect rectSrc = new Rect(0,0,100,100);
        Rect rectDst = new Rect(0,0,100,100);
        canvas.drawBitmap(mBitmap,null,rectDst,mPaint);



    }
}
