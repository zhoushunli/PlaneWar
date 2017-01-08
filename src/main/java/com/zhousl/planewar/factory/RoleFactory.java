package com.zhousl.planewar.factory;

import com.zhousl.planewar.roles.Role;

/**
 * Created by shunli on 2017/1/8.
 */

public class RoleFactory {

    public <T extends Role>T createRole(Class<T> clazz){
        Role role=null;
        try {
            role=((Role) Class.forName(clazz.getName()).newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) role;
    }
}
