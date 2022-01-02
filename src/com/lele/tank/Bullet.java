package com.lele.tank;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/2 15:12
 * @description: 子弹类
 */
public class Bullet {

    private static final int SPEED = 10; // 子弹的速度
    private static int WIDTH = 30, HEIGHT = 30; // 子弹的大小
    private int x, y; // 子弹的位置
    private Dir dir; // 子弹的方向
    private boolean live = true; // 子弹是否有效
    private TankFrame tf = null;


    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    /**
     * 画子弹
     * @param g
     */
    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
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

        // 子弹飞出游戏窗口后，子弹无效
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }

    }
}
