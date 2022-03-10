package com.lele.tank.observer;

import com.lele.tank.Tank;

/**
 * @author: lele
 * @date: 2022/3/11 7:22
 * @description:
 */
public class TankFireHandler implements TankFireObserver {

    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
