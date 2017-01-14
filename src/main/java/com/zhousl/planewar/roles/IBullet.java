package com.zhousl.planewar.roles;

import android.graphics.RectF;

/**
 * Created by Administrator on 2017/1/14.
 */

public interface IBullet {
    void setLocation(float left,float top);
    RectF getLocation();
    void setMaxDamage(int maxHP);
    int getMaxDamage();
    void destroy();
}
