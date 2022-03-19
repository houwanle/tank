package com.lele.tank.strategy;

import com.lele.tank.Tank;

import java.io.Serializable;

/**
 * @author: lele
 * @date: 2022/1/9 10:26
 * @description: 开火策略接口
 */
public interface FireStrategy extends Serializable {
    void fire(Tank t);
}
