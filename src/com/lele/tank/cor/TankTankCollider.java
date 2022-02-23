package com.lele.tank.cor;

import com.lele.tank.Bullet;
import com.lele.tank.GameObject;
import com.lele.tank.Tank;

/**
 * @author: lele
 * @date: 2022/2/21 20:39
 * @description: 坦克与坦克的碰撞检测
 */
public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.stop();
            }
        }

        return true;
    }
}
