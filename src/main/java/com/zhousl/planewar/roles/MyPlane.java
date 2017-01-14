package com.zhousl.planewar.roles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Administrator on 2017/1/6.
 */

public class MyPlane extends Role{

    private RectF mLocation;

    public MyPlane(){
        mLocation=new RectF();
    }

    @Override
    public void destroyRole() {

    }

    @Override
    protected RectF getCurLocation() {
        return mLocation;
    }

    @Override
    public void drawSelf(Canvas canvas, Paint paint) {
        if (mLocation.isEmpty())
            throw new IllegalStateException("Role size and location must be specified!!!");
        canvas.save();
        canvas.drawRect(mLocation,paint);
        canvas.restore();
    }
}
