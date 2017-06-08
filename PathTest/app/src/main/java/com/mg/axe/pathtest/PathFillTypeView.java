package com.mg.axe.pathtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Chen on 2017/6/2.
 * 对Path的FillType进行理解
 */

public class PathFillTypeView extends View {

    private int fillType = FILL_TYPE_INVERSE_EVEN_ODD;

    private Path mPath;
    private Paint mPaint;

    public PathFillTypeView(Context context) {
        this(context,null);
    }

    public PathFillTypeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathFillTypeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public static final int FILL_TYPE_INVERSE_EVEN_ODD = 3;
    public static final int FILL_TYPE_INVERSE_WINDING = 2;
    public static final int FILL_TYPE_EVEN_ODD = 1;
    public static final int FILL_TYPE_WINDING = 0;

    public void setFillType(int type){
        fillType = type;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        clear(canvas);
        canvas.drawColor(Color.WHITE);
        switch (fillType){
            case FILL_TYPE_INVERSE_EVEN_ODD:
                // 取path所有未占和相交的区域
                drawInverseEvenOdd(canvas);
                break;
            case FILL_TYPE_INVERSE_WINDING:
                //取path所有未占的区域
                drawInverseWinding(canvas);
                break;
            case FILL_TYPE_EVEN_ODD:
                //连个path 不共有的部分
                drawEvenOddType(canvas);
                break;
            case FILL_TYPE_WINDING:
                //取Path所有所在的区域 -- 默认的模式
                drawWindingType(canvas);
                break;
        }
    }

    public void clear(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

        invalidate();
    }

    public void drawInverseEvenOdd(Canvas canvas) {
        mPath = new Path();
        mPath.offset(100,100);
        mPath.addCircle(200, 200, 100, Path.Direction.CW);
        mPath.addCircle(300, 300, 100, Path.Direction.CW);
        mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        mPaint.setColor(Color.RED);
        canvas.drawPath(mPath,mPaint);
    }

    public void drawInverseWinding(Canvas canvas) {
        mPath = new Path();
        mPath.offset(100,100);
        mPath.addCircle(200, 200, 100, Path.Direction.CW);
        mPath.addCircle(300, 300, 100, Path.Direction.CW);
        mPath.setFillType(Path.FillType.INVERSE_WINDING);
        mPaint.setColor(Color.RED);
        canvas.drawPath(mPath,mPaint);
    }

    public void drawEvenOddType(Canvas canvas) {
        mPath = new Path();
        mPath.offset(100,100);
        mPath.addCircle(200, 200, 100, Path.Direction.CW);
        mPath.addCircle(300, 300, 100, Path.Direction.CW);
        mPath.setFillType(Path.FillType.EVEN_ODD);
        mPaint.setColor(Color.RED);
        canvas.drawPath(mPath,mPaint);
    }

    public void drawWindingType(Canvas canvas) {
        mPath = new Path();
        mPath.offset(100,100);
        mPath.addCircle(200, 200, 100, Path.Direction.CW);
        mPath.addCircle(300, 300, 100, Path.Direction.CW);
        mPath.setFillType(Path.FillType.WINDING);
        mPaint.setColor(Color.RED);
        canvas.drawPath(mPath,mPaint);
    }
}
