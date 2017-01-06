package com.zhousl.planewar.roles;

import android.graphics.PointF;

/**
 * Created by Administrator on 2017/1/6.
 */

public interface IRole {
    void setLocation(float x,float y);
    PointF getLocation();
}
