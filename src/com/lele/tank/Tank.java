package com.lele.tank;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/2 12:10
 * @description: 坦克类
 */
public class Tank {

    private int x, y; // 坦克的大小
    private Dir dir = Dir.DOWN; // 坦克的方向
    private static final int SPEED = 10; // 坦克的速度

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     * 画坦克
     * @param g
     */
    public void paint(Graphics g) {
        // 填充一个矩形
        g.fillRect(x, y, 50, 50);

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
