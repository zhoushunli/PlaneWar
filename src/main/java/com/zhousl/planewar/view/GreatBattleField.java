package com.zhousl.planewar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.zhousl.planewar.R;
import com.zhousl.planewar.roles.Bullet;
import com.zhousl.planewar.roles.EnemyPlane;
import com.zhousl.planewar.roles.MyBullet;
import com.zhousl.planewar.roles.MyPlane;
import com.zhousl.planewar.roles.Role;
import com.zhousl.planewar.thread.BulletThread;
import com.zhousl.planewar.thread.RoleThread;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/10.
 */

public class GreatBattleField extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private boolean keepDraw;
    private SurfaceHolder mHolder;
    private Paint mPaint;
    private Bitmap bitmap;
    private float preX;
    private float preY;
    private int width;
    private int height;
    private ArrayList<Bullet> bullets;
    private ArrayList<Role> enemies;
    private Role myPlane;

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
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        height = bitmap.getHeight();
        width = bitmap.getWidth();
        keepDraw = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        generateEnemies(width);
        generateMyPlane(width, height);
        generateMyBullets();
    }

    private void generateMyBullets() {
        bullets = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Bullet bullet = new MyBullet(myPlane);
            bullets.add(bullet);
        }
        new Thread(new BulletThread(bullets,myPlane)).start();
    }

    private void generateMyPlane(int width, int height) {
        myPlane = new MyPlane();
        myPlane.setLocation(width / 2-100,height-200,width/2+100, height - 100);
    }

    private void generateEnemies(int width) {
        enemies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Role role = new EnemyPlane(new RectF(width / 10 * i-20,0,width/10*i+20, 40));
            enemies.add(role);
        }
        new Thread(new RoleThread(enemies)).start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        keepDraw = false;
    }

    @Override
    public void run() {
        while (keepDraw) {
            Canvas canvas = mHolder.lockCanvas();
            if (canvas == null)
                break;
            canvas.drawColor(Color.YELLOW);
            drawEnemies(canvas);
            drawMyPlane(canvas);
            drawBullets(canvas);
            mHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawEnemies(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        for (Role enemy : enemies) {
            enemy.drawSelf(canvas,mPaint);
        }
    }

    private void drawMyPlane(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        myPlane.drawSelf(canvas,mPaint);
    }

    private void drawBullets(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);
        for (Bullet bullet : bullets) {
            bullet.drawSelf(canvas,mPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        if (!myPlane.getLocation().contains(x,y)){
            return false;
        }
        switch (action){
            case MotionEvent.ACTION_DOWN:
                preX=x;
                preY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                myPlane.setLocation(x-((myPlane.getLocation().right-myPlane.getLocation().left)/2),
                        x-((myPlane.getLocation().bottom-myPlane.getLocation().top)/2),
                        x+((myPlane.getLocation().right-myPlane.getLocation().left)/2),
                        x+((myPlane.getLocation().bottom-myPlane.getLocation().top)/2));
                break;
            case MotionEvent.ACTION_UP:
                return false;
        }
        return true;
    }
}
