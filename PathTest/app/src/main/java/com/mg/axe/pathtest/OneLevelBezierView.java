package com.mg.axe.pathtest;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Chen on 2017/6/4.
 * 一阶赛贝尔曲线至少需要三个坐标才能画 起始点 控制点 终点
 * 这个view将起始点 终点 定义一个固定的值，通过改变控制点展现一阶赛贝尔曲线
 */

public class OneLevelBezierView extends View {

    private Paint paint;

    private int startX;
    private int startY;

    private int endX;
    private int endY;

    private int controlX = 200;
    private int controlY = 60;

    private Path path;


    public OneLevelBezierView(Context context) {
        this(context, null);
    }

    public OneLevelBezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OneLevelBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);

        initPoint();

        path = new Path();
    }

    private void initPoint() {
        startX = 60;
        startY = 350;
        endX = 450;
        endY = 350;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        path.reset();
        path.moveTo(startX, startY);
        path.quadTo(controlX, controlY, endX, endY);
        canvas.drawPath(path, paint);
        canvas.drawPoint(controlX, controlY, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            controlX = (int) event.getX();
            controlY = (int) event.getY();
            invalidate();
        }
        return true;
    }
}
