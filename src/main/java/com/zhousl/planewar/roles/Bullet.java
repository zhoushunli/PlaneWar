package com.zhousl.planewar.roles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Administrator on 2017/1/14.
 */

public abstract class Bullet implements IBullet{

    private RectF mLocation;
    private int maxDamage;
    private int width=20;
    private int height=20;
    private Role myPlane;

    public Bullet(){
    }

    public Bullet(Role myPlane){
        this.myPlane=myPlane;
        setLocation(myPlane.getLocation().left,myPlane.getLocation().top);
    }

    @Override
    public void setLocation(float left, float top) {
        if (mLocation==null)
            mLocation=new RectF();
        mLocation.set(left,top,left+width,top+height);
    }

    public abstract void drawSelf(Canvas canvas, Paint paint);

    @Override
    public RectF getLocation() {
        return mLocation;
    }

    @Override
    public void setMaxDamage(int maxDamage) {
        this.maxDamage=maxDamage;
    }

    @Override
    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public void destroy() {

    }
}
