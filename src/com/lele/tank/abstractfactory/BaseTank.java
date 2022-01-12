package com.lele.tank.abstractfactory;

import com.lele.tank.Group;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/11 7:45
 * @description:
 */
public abstract class BaseTank {

    public Group group = Group.BAD; //敌方

    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

//    public abstract void collideWith(BaseTank tank);

    public Group getGroup() {
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
