package com.lele.tank;

import java.awt.*;
import java.io.Serializable;

/**
 * @author: lele
 * @date: 2022/2/21 7:28
 * @description: 游戏对象  名词用抽象类，形容词用接口
 */
public abstract class GameObject implements Serializable {
    public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();
}
