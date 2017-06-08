package com.mg.axe.pathtest;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Chen on 2017/6/3.
 */

public class PathOpView extends View {

    private Paint mPaint;

    public static final int OP_TYPE_DIFFERENCE = 0;
    public static final int OP_TYPE_INTERSECT = 1;
    public static final int OP_TYPE_UNION = 2;
    public static final int OP_TYPE_XOR = 3;
    public static final int OP_TYPE_REVERSE_DIFFERENCE = 4;

    private int opType = OP_TYPE_DIFFERENCE;

    public PathOpView(Context context) {
        super(context, null);
    }

    public PathOpView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathOpView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    public void setType(int type) {
        this.opType = type;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        clear(canvas);
        canvas.drawColor(Color.WHITE);
        resetPaint();
        switch (opType) {
            case OP_TYPE_DIFFERENCE:
                // path 1 - path 2 剩下的部分
                drawDifferenceOp(canvas);
                break;
            case OP_TYPE_INTERSECT:
                //path 1 - path 2 交集
                drawIntersectOp(canvas);
                break;
            case OP_TYPE_UNION:
                // path 1 -  path 2  外围部分
                drawUnionOp(canvas);
                break;
            case OP_TYPE_XOR:
                // path 1  - path 2 所有部分
                drawXorOp(canvas);
                break;
            case OP_TYPE_REVERSE_DIFFERENCE:
                //path 2 - path 1 剩下的部分（和DIFFERENCE 正好相反）
                drawReverseDifferenceOp(canvas);
                break;
        }
    }

    private void resetPaint() {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }


    public void clear(Canvas canvas) {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

        invalidate();
    }

    private void drawDifferenceOp(Canvas canvas) {
        Path path1 = new Path();
        path1.addCircle(150, 150, 100, Path.Direction.CW);
        Path path2 = new Path();
        path2.addCircle(200, 200, 100, Path.Direction.CW);
        path1.op(path2, Path.Op.DIFFERENCE);
        canvas.drawPath(path1, mPaint);
        canvas.save();
        mPaint.setColor(Color.DKGRAY);
        mPaint.setStrokeWidth(2);
        canvas.drawCircle(150, 150, 100, mPaint);
        canvas.drawCircle(200, 200, 100, mPaint);
    }

    private void drawIntersectOp(Canvas canvas) {
        Path path1 = new Path();
        path1.addCircle(150, 150, 100, Path.Direction.CW);
        Path path2 = new Path();
        path2.addCircle(200, 200, 100, Path.Direction.CW);
        path1.op(path2, Path.Op.INTERSECT);
        canvas.drawPath(path1, mPaint);
        mPaint.setColor(Color.DKGRAY);
        mPaint.setStrokeWidth(2);
        canvas.drawCircle(150, 150, 100, mPaint);
        canvas.drawCircle(200, 200, 100, mPaint);
    }

    private void drawUnionOp(Canvas canvas) {
        Path path1 = new Path();
        path1.addCircle(150, 150, 100, Path.Direction.CW);
        Path path2 = new Path();
        path2.addCircle(200, 200, 100, Path.Direction.CW);
        path1.op(path2, Path.Op.UNION);
        canvas.drawPath(path1, mPaint);
        mPaint.setColor(Color.DKGRAY);
        mPaint.setStrokeWidth(2);
        canvas.drawCircle(150, 150, 100, mPaint);
        canvas.drawCircle(200, 200, 100, mPaint);
    }

    private void drawXorOp(Canvas canvas) {
        Path path1 = new Path();
        path1.addCircle(150, 150, 100, Path.Direction.CW);
        Path path2 = new Path();
        path2.addCircle(200, 200, 100, Path.Direction.CW);
        path1.op(path2, Path.Op.XOR);
        canvas.drawPath(path1, mPaint);
        mPaint.setColor(Color.DKGRAY);
        mPaint.setStrokeWidth(2);
        canvas.drawCircle(150, 150, 100, mPaint);
        canvas.drawCircle(200, 200, 100, mPaint);
    }

    private void drawReverseDifferenceOp(Canvas canvas) {
        Path path1 = new Path();
        path1.addCircle(150, 150, 100, Path.Direction.CW);
        Path path2 = new Path();
        path2.addCircle(200, 200, 100, Path.Direction.CW);
        path1.op(path2, Path.Op.REVERSE_DIFFERENCE);
        canvas.drawPath(path1, mPaint);
        mPaint.setColor(Color.DKGRAY);
        mPaint.setStrokeWidth(2);
        canvas.drawCircle(150, 150, 100, mPaint);
        canvas.drawCircle(200, 200, 100, mPaint);
    }
}
