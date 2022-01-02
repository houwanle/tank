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
    private static final int SPEED = 5; // 坦克的速度
    private boolean moving = false;  // 坦克是否在移动
    private TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    /**
     * 画坦克
     * @param g
     */
    public void paint(Graphics g) {
        Color c = g.getColor();//保存原来的颜色
        g.setColor(Color.YELLOW);//设置坦克的颜色
        // 填充一个矩形
        g.fillRect(x, y, 50, 50);
        g.setColor(c);// 将颜色设置成原来的颜色

        move();

    }

    /**
     * 坦克移动
     */
    private void move() {
        if (!moving) {
            return;
        }
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

    /**
     * 发射子弹
     */
    public void fire() {
        tf.b = new Bullet(this.x, this.y, this.dir);
    }
}
