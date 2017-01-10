package com.zhousl.planewar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.zhousl.planewar.R;

/**
 * Created by Administrator on 2017/1/10.
 */

public class GreatBattleField extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private boolean keepDraw;
    private SurfaceHolder mHolder;
    private Paint mPaint;
    private int t;
    private Bitmap bitmap;
    private float preX;
    private float preY;
    private int width;
    private int height;

    public GreatBattleField(Context context) {
        this(context, null);
    }

    public GreatBattleField(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHolder = getHolder();
        mHolder.addCallback(this);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        setBackgroundColor(Color.WHITE);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        height = bitmap.getHeight();
        width = bitmap.getWidth();
//        if (bitmap == null)
//            bitmap = Bitmap.createBitmap(new int[]{Color.RED}, 1000, 1500, Bitmap.Config.ARGB_8888);
//        Canvas canvas = mHolder.lockCanvas();
//        canvas.drawColor(Color.WHITE);
//        canvas.drawBitmap(bitmap, 0, 0, null);
//        mHolder.unlockCanvasAndPost(canvas);
        keepDraw = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        keepDraw = false;
    }

    @Override
    public void run() {
        while (keepDraw) {
            if (t == 600)
                t = 0;
            Canvas canvas = mHolder.lockCanvas();
            if (canvas == null)
                break;
            canvas.drawColor(Color.YELLOW);
            canvas.drawBitmap(bitmap, preX-width/2, preY-height/2, null);
            canvas.drawRect(t, t, 400 + t, 400 + t, mPaint);
            mHolder.unlockCanvasAndPost(canvas);
            SystemClock.sleep(20);
            t += 2;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        Log.i("touch---", event.getX() + "-------" + event.getY());
        if (action == MotionEvent.ACTION_DOWN) {
            preX = event.getX();
            preY = event.getY();
        } else if (action == MotionEvent.ACTION_MOVE) {
            preX = event.getX();
            preY = event.getY();
        } else {
            return false;
        }
        return true;
    }
}
