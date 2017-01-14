package com.zhousl.planewar.roles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Administrator on 2017/1/6.
 */

public class EnemyPlane extends Role{

    private RectF mLocation;

    public EnemyPlane(RectF rectF){
        this();
        setLocation(rectF);
    }

    public EnemyPlane(){
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
        canvas.save();
        canvas.drawRect(mLocation,paint);
        canvas.restore();
    }
}
