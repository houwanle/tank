package com.lele.tank;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/2 15:12
 * @description: 子弹类
 */
public class Bullet {

    private static final int SPEED = 6; // 子弹的速度
    public static int WIDTH = ResourceMgr.bulletU.getWidth(); // 子弹的宽度
    public static int HEIGHT = ResourceMgr.bulletU.getHeight(); //子弹的高度

    private int x, y; // 子弹的位置
    private Dir dir; // 子弹的方向

    private boolean living = true; // 子弹是否有效
    private TankFrame tf = null;
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * 画子弹
     * @param g
     */
    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null); //画向左子弹图片
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null); //画向上子弹图片
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null); //画向右子弹图片
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null); //画向下子弹图片
                break;
        }

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
            living = false;
        }

    }

    /**
     * 碰撞
     * @param tank
     */
    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {//队友不能互相伤害
            return;
        }

        // todo:用一个rect来记录子弹的位置
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);

        if (rect1.intersects(rect2)) { // 如果两个方块相交,坦克子弹都消失
            tank.die();
            this.die();
            tf.explodes.add(new Explode(x, y, tf));
        }
    }

    /**
     * 子弹击中坦克后爆炸
     */
    private void die() {
        this.living = false;
    }
}
