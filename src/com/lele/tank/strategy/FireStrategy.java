package com.lele.tank.strategy;

import com.lele.tank.Tank;

/**
 * @author: lele
 * @date: 2022/1/9 10:26
 * @description: 开火策略接口
 */
public interface FireStrategy {
    void fire(Tank t);
}
