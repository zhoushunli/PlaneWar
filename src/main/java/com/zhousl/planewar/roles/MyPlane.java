package com.zhousl.planewar.roles;

import android.graphics.PointF;

/**
 * Created by Administrator on 2017/1/6.
 */

public class MyPlane extends Role{

    private PointF mLocation;

    public MyPlane(){
        mLocation=new PointF();
    }

    @Override
    public void destroyRole() {

    }

    @Override
    protected PointF getCurLocation() {
        return mLocation;
    }
}
