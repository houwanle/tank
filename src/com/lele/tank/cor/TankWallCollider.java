package com.lele.tank.cor;

import com.lele.tank.GameObject;
import com.lele.tank.Tank;
import com.lele.tank.Wall;

/**
 * @author: lele
 * @date: 2022/3/1 7:25
 * @description: 坦克与墙碰撞
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;

            if (t.rect.intersects(w.rect)) {
                t.back();
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            return collide(o2, o1);
        }
        return true;
    }
}
