package com.lele.tank.observer;

import com.lele.tank.Tank;

/**
 * @author: lele
 * @date: 2022/3/11 7:21
 * @description: 坦克开火事件
 */
public class TankFireEvent {

    Tank tank;

    public Tank getSource() {
        return tank;
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
