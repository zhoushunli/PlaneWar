package com.zhousl.planewar.roles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Administrator on 2017/1/6.
 */

public abstract class Role implements IRole {

    private int maxHP;
    private RectF curLocation;

    @Override
    public void setLocation(RectF rectF) {
        curLocation = getCurLocation();
        if (curLocation ==null)
            throw new IllegalArgumentException("no container provided to store curLocation.");
        curLocation.set(rectF);
    }
    public void setLocation(float left,float top,float right,float bottom){
        curLocation=getCurLocation();
        getCurLocation().set(left,top,right,bottom);
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public RectF getLocation() {
        return curLocation;
    }

    protected abstract RectF getCurLocation();
    public abstract void drawSelf(Canvas canvas, Paint paint);
}
