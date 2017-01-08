package com.zhousl.planewar.thread;

import com.zhousl.planewar.factory.RoleFactory;
import com.zhousl.planewar.roles.EnemyPlane;
import com.zhousl.planewar.roles.MyBullet;
import com.zhousl.planewar.view.BattleFieldView;

/**
 * Created by shunli on 2017/1/8.
 */

public class MyBulletThread implements Runnable {

    private BattleFieldView battleField;
    private RoleFactory factory;

    public MyBulletThread(BattleFieldView battleField){
        this.battleField=battleField;
        factory=new RoleFactory();
    }

    @Override
    public void run() {
        MyBullet myBullet = factory.createRole(MyBullet.class);
        battleField.myBullets.add(myBullet);
    }
}
