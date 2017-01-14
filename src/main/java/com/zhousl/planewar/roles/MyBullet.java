package com.zhousl.planewar.roles;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Administrator on 2017/1/6.
 */

public class MyBullet extends Bullet {

    public MyBullet(Role myPlane) {
        super(myPlane);
        setMaxDamage(20);
    }

    public MyBullet(float left, float top) {
        setMaxDamage(20);
        setLocation(left,top);
    }

    @Override
    public void drawSelf(Canvas canvas, Paint paint) {

    }
}
