package com.zhousl.planewar.thread;

import com.zhousl.planewar.roles.Role;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by shunli on 2017/1/8.
 */

public class RoleThread implements Runnable {

    private ArrayList<Role> roles;

    public RoleThread(ArrayList<Role> roles) {
        this.roles = roles;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            Role role = roles.get(random.nextInt(roles.size() - 1));
            role.setLocation(role.getLocation().left, role.getLocation().top + 1, role.getLocation().right, role.getLocation().bottom + 1);
        }
    }
}
