package com.lele.tank.decorator;

import com.lele.tank.GameObject;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/3/4 7:50
 * @description:
 */
public abstract class GODecorator extends GameObject {

    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);


}
