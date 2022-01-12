package com.lele.tank;

import com.lele.tank.abstractfactory.BaseTank;

/**
 * @author: lele
 * @date: 2022/1/9 10:27
 * @description: 默认开火策略
 */
public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        // 让子弹从坦克中心发射
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        new Bullet(bX, bY, t.dir, t.group, t.tf);

        if (t.group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
