package com.lele.tank.strategy;

import com.lele.tank.*;

/**
 * @author: lele
 * @date: 2022/1/9 10:44
 * @description:
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        // 让子弹从坦克中心发射
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bX, bY, dir, t.group, t.gm);
        }

        if (t.group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
