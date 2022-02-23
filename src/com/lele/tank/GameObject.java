package com.lele.tank;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/2/21 7:28
 * @description: 游戏对象  名词用抽象类，形容词用接口
 */
public abstract class GameObject {
    int x, y;

    public abstract void paint(Graphics g);
}
