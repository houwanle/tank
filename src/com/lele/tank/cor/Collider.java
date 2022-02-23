package com.lele.tank.cor;

import com.lele.tank.GameObject;

/**
 * @author: lele
 * @date: 2022/2/21 20:35
 * @description: 碰撞器
 */
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
