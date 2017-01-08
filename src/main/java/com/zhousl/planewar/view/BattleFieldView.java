package com.zhousl.planewar.view;

import android.content.Context;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;

import com.zhousl.planewar.BattleHelper;
import com.zhousl.planewar.roles.Role;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/6.
 */

public class BattleFieldView extends View {

    private Role myPlane;
    public ArrayList<Role> myBullets;
    public ArrayList<Role> enemyPlanes;;
    private BattleHelper helper;

    public BattleFieldView(Context context) {
        super(context);
    }

    public BattleFieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
