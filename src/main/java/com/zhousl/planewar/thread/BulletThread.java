package com.zhousl.planewar.thread;

import android.os.SystemClock;

import com.zhousl.planewar.roles.Bullet;
import com.zhousl.planewar.roles.Role;

import java.util.ArrayList;

/**
 * Created by shunli on 2017/1/8.
 */

public class BulletThread implements Runnable {

    private ArrayList<Bullet> bullets;
    private Role mPlane;

    public BulletThread(ArrayList<Bullet> bullets, Role myPlane) {
        this.bullets = bullets;
        this.mPlane = myPlane;
    }

    @Override
    public void run() {
        while (true) {
            for (Bullet bullet : bullets) {
                bullet.setLocation(mPlane.getLocation().left,
                        bullet.getLocation().top + 3);
                SystemClock.sleep(100);
            }
        }
    }
}
