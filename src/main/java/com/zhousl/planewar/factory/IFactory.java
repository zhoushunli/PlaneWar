package com.zhousl.planewar.factory;

import com.zhousl.planewar.roles.Role;

/**
 * Created by shunli on 2017/1/8.
 */

public interface IFactory {
   <T extends Role> T createRole(Class<T> clazz);
}
