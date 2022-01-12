package com.lele.tank.abstractfactory;

import com.lele.tank.Tank;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/11 7:44
 * @description:
 */
public abstract class BaseBullet {

    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
