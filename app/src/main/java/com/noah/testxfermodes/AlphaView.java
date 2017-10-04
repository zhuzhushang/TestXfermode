package com.noah.testxfermodes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/10/1 0001.
 */

public class AlphaView extends View {

    private static final String TAG = "AlphaView";
    private Context context;
    private int wh = 400;
    private Paint mPaint;
    private int alpha = 255;
    private Bitmap mGreenBitmap;
    private Bitmap iconBitmap;
    private String theGreenColor = "#44BF1A";


    public AlphaView(Context context) {
        this(context,null);
    }

    public AlphaView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AlphaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);


    }

    private void init(Context context) {

        this.context = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setFilterBitmap(true);
        mGreenBitmap = makeGreenBitmap();
        iconBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.iconfont_faxian);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawColor(Color.parseColor("#44BF1A"));

        mPaint.setAlpha(255);
        canvas.drawBitmap(iconBitmap,0,0,mPaint);
//        int count = canvas.saveLayer(0,0,canvas.getWidth(),canvas.getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);

        mPaint.setAlpha(255);
        canvas.drawBitmap(iconBitmap,0,0,mPaint);

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setAlpha(alpha);
        canvas.drawBitmap(mGreenBitmap,0,0,mPaint);
        mPaint.setXfermode(null);
//        canvas.restoreToCount(count);

    }




    public Bitmap makeGreenBitmap(){

        Bitmap bitmap = Bitmap.createBitmap(wh,wh, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setARGB(alpha,68,191,26);
        Rect rect = new Rect(0,0,wh,wh);
        canvas.drawRect(rect,paint);
        return bitmap;

    }



    public void setAlpha(int alpha){

        alpha = alpha < 0 ? 0 : alpha;
        alpha = alpha > 255 ? 255 : alpha;

        this.alpha = alpha;
        Log.e(TAG, "setAlpha: --->"+alpha);
        invalidate();
    }

    public int getAlpha1() {
        return alpha;
    }
}
