package com.lele.tank.observer;

import java.io.Serializable;

/**
 * @author: lele
 * @date: 2022/3/11 7:23
 * @description:
 */
public interface TankFireObserver extends Serializable {

    void actionOnFire(TankFireEvent e);
}
