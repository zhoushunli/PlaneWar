package com.zhousl.planewar.thread;

import com.zhousl.planewar.BattleHelper;
import com.zhousl.planewar.factory.RoleFactory;
import com.zhousl.planewar.roles.EnemyPlane;
import com.zhousl.planewar.view.BattleFieldView;

/**
 * Created by shunli on 2017/1/8.
 */

public class EnemyThread implements Runnable {

    private BattleFieldView battleField;
    private RoleFactory factory;

    public EnemyThread(BattleFieldView battleField){
        this.battleField=battleField;
        factory=new RoleFactory();
    }

    @Override
    public void run() {
        EnemyPlane enemyPlane = factory.createRole(EnemyPlane.class);
        battleField.enemyPlanes.add(enemyPlane);
    }
}
