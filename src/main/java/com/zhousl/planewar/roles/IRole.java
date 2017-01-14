package com.zhousl.planewar.roles;

import android.graphics.RectF;

/**
 * Created by Administrator on 2017/1/6.
 */

public interface IRole {
    void setLocation(RectF rectF);
    RectF getLocation();
    void destroyRole();
}
