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

    public static int WIDTH = ResourceMgr.tankD.getWidth(); // 坦克的宽度
    public static int HEIGHT = ResourceMgr.tankD.getHeight();// 坦克的高度

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

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null); //画向左坦克图片
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null); //画向上坦克图片
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null); //画向右坦克图片
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null); //画向下坦克图片
                break;
        }

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
        // 让子弹从坦克中心发射
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        tf.bullets.add(new Bullet(bX, bY, this.dir, this.tf));
    }
}
