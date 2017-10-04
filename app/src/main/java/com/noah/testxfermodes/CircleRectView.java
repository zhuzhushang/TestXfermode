package com.noah.testxfermodes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/26 0026.
 */

public class CircleRectView extends View {

    private Context context;
    private Paint mPaint;
    private int width;
    private int height;
    private Bitmap mSrc,mDst;

    private int wh = 400;


    public CircleRectView(Context context) {
        super(context);

        init(context);
    }



    public CircleRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

        this.context = context;

//        mSrc = BitmapFactory.decodeResourceStream()
        mSrc = BitmapFactory.decodeResource(getResources(),R.mipmap.src);
        mDst = BitmapFactory.decodeResource(getResources(),R.mipmap.dst);

        mPaint = new Paint();
        //设置防锯齿
        mPaint.setAntiAlias(true);
        //设置防抖动
        mPaint.setDither(true);
//        setLayerType(View.LAYER_TYPE_SOFTWARE,null);


    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = canvas.getWidth() >> 1;
        int centerY = canvas.getHeight() >> 1;





        /*//画矩形
        drawRect(canvas);
        //设置xfermodes
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mPaint.setAlpha(255);
        //画圆
        drawCircle(canvas);*/

//        //画白色背景
//        mPaint.setColor(Color.WHITE);
//        Rect rect = new Rect(0,0,canvas.getWidth(),canvas.getHeight());
//        canvas.drawRect(rect,mPaint);

//        canvas.drawColor(Color.WHITE);
//        //将绘制操作保存到新的图层，因为图像合成是很昂贵的操作，将用到硬件加速，这里将图像合成的处理放到离屏缓存中进行
//        int saveCount = canvas.saveLayer(srcRect, mPaint, Canvas.ALL_SAVE_FLAG);


       /* //画矩形
        drawDstBitmap(canvas);
        //设置xfermodes
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        //画圆
        drawSrcBitmap(canvas);*/

//       Bitmap bitmap = Bitmap.createBitmap(wh,wh, Bitmap.Config.ARGB_8888);
//       canvas.drawBitmap(bitmap,0,0,mPaint);

//        canvas.drawColor(Color.RED);
//        canvas.translate(600,400);
//        canvas.scale(600,400);

//        Bitmap bm = Bitmap.createBitmap(new int[] { 0xFFFFFFFF, 0xFFCCCCCC,
//                        0xFFCCCCCC, 0xFFFFFFFF }, 2, 2,
//                Bitmap.Config.RGB_565);
//        Shader mBG = new BitmapShader(bm,
//                Shader.TileMode.REPEAT,
//                Shader.TileMode.REPEAT);
//
//        mPaint.setShader(mBG);
//        canvas.drawRect(0,0,720,1280,mPaint);


//        canvas.drawBitmap(drawDstBitmap(),0,0,mPaint);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        canvas.drawBitmap(drawSrcBitmap(),0,0,mPaint);

//        canvas.drawBitmap(mDst,0,0,mPaint);
//        canvas.saveLayer(0,0,canvas.getWidth(),canvas.getHeight(),mPaint);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
//        canvas.drawBitmap(mSrc,0,0,mPaint);
//        canvas.restore();
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
//        canvas.drawBitmap(mSrc,150,150,mPaint);




        //画点
//        mPaint.setColor(Color.parseColor("#ffff0000"));
//        mPaint.setStrokeWidth(40);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeCap(Paint.Cap.BUTT);
//        canvas.drawPoint(centerX,centerY - 100,mPaint);
//
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawPoint(centerX,centerY - 60,mPaint);

//        mPaint.setStrokeCap(Paint.Cap.ROUND);
////        canvas.drawPoint(centerX,centerY - 20,mPaint);
//        float pointArray[] = {100,200,300,300,400,400,600,600};
//        canvas.drawPoints(pointArray,1,2,mPaint);

//        Rect rect = new Rect(0,0,200,200);
//        Paint paint = new Paint();
//        paint.setColor(Color.YELLOW);
//        canvas.drawRect(rect,paint);
//
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
//
//        RectF rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
//        int count = canvas.saveLayerAlpha(rectF,256);
//        paint.setColor(Color.BLUE);
//        canvas.drawCircle(200,200,100,paint);
//
////        canvas.translate(100,100);
//        canvas.restoreToCount(count);

//        canvas.drawBitmap(mDst,0,0,mPaint);
//        canvas.save();
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        canvas.drawBitmap(mSrc,150,150,mPaint);
//        canvas.restore();

//        canvas.drawBitmap(drawDstBitmap(),0,0,mPaint);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
//        canvas.drawBitmap(drawSrcBitmap(),0,0,mPaint);


//        mSrc = BitmapFactory.decodeResource(getResources(),R.mipmap.src);//蓝色
//        mDst = BitmapFactory.decodeResource(getResources(),R.mipmap.dst);//黄色
//
//        RectF rectF = new RectF(0,0,canvas.getWidth(),getHeight());
//        int dstLayer = canvas.saveLayerAlpha(rectF,255);
//        canvas.drawBitmap(mDst,0,0,mPaint);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        canvas.restoreToCount(dstLayer);
//        int srcLayer = canvas.saveLayerAlpha(rectF,255);
//        canvas.drawBitmap(mSrc,150,150,mPaint);
//        mPaint.setXfermode(null);
//        canvas.restoreToCount(srcLayer);



//        Paint paintRed = generatePaint(Color.RED, Paint.Style.STROKE,3);
//        Paint paintGreen = generatePaint(Color.GREEN, Paint.Style.STROKE,3);
//        Paint paintBlue = generatePaint(Color.BLUE, Paint.Style.STROKE,3);
//        Paint paintYellow = generatePaint(Color.YELLOW, Paint.Style.STROKE,3);
//        Paint paintGray  = generatePaint(Color.GRAY,Paint.Style.STROKE,3);
//        Paint paintScreen = generatePaint(Color.parseColor("#8f000000"), Paint.Style.STROKE,3);
//        Rect rect = new Rect(0,0,400,200);
//        Rect rectScreen = new Rect(0,0,canvas.getWidth(),canvas.getHeight());

//        canvas.drawRect(rect,paintGreen);
//        canvas.translate(100,100);
//        canvas.drawRect(rect,paintRed);
//
//        canvas.rotate(30);
//        canvas.drawRect(rect,paintBlue);
//
//        canvas.scale(0.5f,0.5f);
////        canvas.drawRect(rect,paintYellow);
//        canvas.drawRect(rectScreen,paintScreen);
//
//        canvas.scale(2,2);
//        canvas.translate(100,100);
//        canvas.drawRect(rect,paintGray);

//        canvas.drawRect(rect,paintBlue);
////        canvas.skew(1.732f,0);
//        canvas.skew(0,-0.577f);
//        canvas.drawRect(rect,paintGray);


        int wh = 800;
        Paint paintX = new Paint();
        paintX.setAntiAlias(true);
        paintX.setDither(true);

        RectF rectLayer = new RectF(0,0,800,800);

        canvas.drawColor(Color.GREEN);
        int count = canvas.saveLayer(rectLayer,paintX);
        canvas.drawBitmap(mDst,0,0,paintX);
        paintX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mSrc,150,150,paintX);

        canvas.restoreToCount(count);
        paintX.setXfermode(null);



    }

    public Paint generatePaint(int color){


        return generatePaint(color, Paint.Style.STROKE,3);

    }

    public Paint generatePaint(int color, Paint.Style style, int width){

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }

    private Bitmap drawDstBitmap() {



        Bitmap bitmap = Bitmap.createBitmap(wh,wh, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,wh,wh,paint);

        return bitmap;

    }

    private Bitmap drawSrcBitmap() {

        Bitmap bitmap = Bitmap.createBitmap(wh << 1,wh << 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        canvas.drawCircle(400,400,200,paint);
        return bitmap;
    }

    private void drawRect(Canvas canvas) {

        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);
        Rect rect = new Rect(0,0,400,400);
        canvas.drawRect(rect,mPaint);


    }

    private void drawCircle(Canvas canvas) {

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(400,400,200,mPaint);
    }
}
