package com.lele.tank.cor;

import com.lele.tank.Bullet;
import com.lele.tank.GameObject;
import com.lele.tank.Tank;
import com.lele.tank.Wall;

/**
 * @author: lele
 * @date: 2022/2/28 7:33
 * @description: 子弹与墙的碰撞
 */
public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;

            if (b.rect.intersects(w.rect)) {
                b.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
