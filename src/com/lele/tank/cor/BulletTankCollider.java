package com.lele.tank.cor;

import com.lele.tank.Bullet;
import com.lele.tank.Explode;
import com.lele.tank.GameObject;
import com.lele.tank.Tank;

/**
 * @author: lele
 * @date: 2022/2/21 20:39
 * @description: 子弹与坦克的碰撞检测
 */
public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;

            if (b.group == t.getGroup()) {
                return true;
            }

            if (b.rect.intersects(t.rect)) {
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                int eY = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                new Explode(eX, eY);
                return false;
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }

        return true;
    }
}
