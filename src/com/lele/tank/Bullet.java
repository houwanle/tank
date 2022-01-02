package com.lele.tank;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/2 15:12
 * @description: 子弹类
 */
public class Bullet {

    private static final int SPEED = 1; // 子弹的速度
    private int x, y; // 子弹的位置
    private Dir dir; // 子弹的方向
    private static int WIDTH = 30, HEIGHT = 30; // 子弹的大小

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     * 画子弹
     * @param g
     */
    public void paint(Graphics g) {
        Color c = g.getColor(); // 获取原来的颜色
        g.setColor(Color.RED); // 设置子弹的颜色
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c); // 设置为原来的颜色

        move(); // 子弹移动
    }

    /**
     * 子弹移动
     */
    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }
}
