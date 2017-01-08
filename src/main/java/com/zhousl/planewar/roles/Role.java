package com.zhousl.planewar.roles;

import android.graphics.PointF;

/**
 * Created by Administrator on 2017/1/6.
 */

public abstract class Role implements IRole {

    private PointF curLocation;

    @Override
    public void setLocation(float x, float y) {
        curLocation = getCurLocation();
        if (curLocation ==null)
            throw new IllegalArgumentException("no container provided to store curLocation.");
        curLocation.set(x,y);
    }

    @Override
    public PointF getLocation() {
        return curLocation;
    }

    protected abstract PointF getCurLocation();
}
