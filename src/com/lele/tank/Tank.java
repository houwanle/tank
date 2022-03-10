package com.lele.tank;

import com.lele.tank.observer.TankFireEvent;
import com.lele.tank.observer.TankFireHandler;
import com.lele.tank.observer.TankFireObserver;
import com.lele.tank.strategy.DefaultFireStrategy;
import com.lele.tank.strategy.FireStrategy;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: lele
 * @date: 2022/1/2 12:10
 * @description: 坦克类
 */
public class Tank extends GameObject {

//    public int x, y; // 坦克的大小
     int oldX, oldY;
    public Dir dir = Dir.DOWN; // 坦克的方向
    private static final int SPEED = 2; // 坦克的速度

    public static int WIDTH = ResourceMgr.goodTankU.getWidth(); // 坦克的宽度
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();// 坦克的高度

    public Rectangle rect = new Rectangle();

    private Random random = new Random();

    private boolean moving = true;  // 坦克是否在移动

    private boolean living = true;  //坦克是否活着
    public Group group = Group.BAD; //敌方

    FireStrategy fs;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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

    public Rectangle getRect() {
        return rect;
    }

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GOOD) {
            String goodFSName = (String)PropertyMgr.get("goodFS");
            try {
                fs = (FireStrategy)Class.forName(goodFSName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
//            String badFS = (String)PropertyMgr.get("badFS");
//            try {
//                fs = (FireStrategy)Class.forName(badFS).newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
            fs = new DefaultFireStrategy();
        }

        GameModel.getInstance().add(this);
    }

    /**
     * 画坦克
     * @param g
     */
    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,
                        x, y, null); //画向左坦克图片
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,
                        x, y, null); //画向上坦克图片
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,
                        x, y, null); //画向右坦克图片
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,
                        x, y, null); //画向下坦克图片
                break;
        }

        move();
    }

    public void back() {
        x = oldX;
        y = oldY;
    }

    /**
     * 坦克移动
     */
    private void move() {
        // 记录移动之前的位置
        oldX = x;
        oldY = y;

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

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheck();

        // 更新 rect
        rect.x = this.x;
        rect.y = this.y;
    }

    /**
     * 边界检测
     */
    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }

        if (this.y < 28) {
            y = 28;
        }

        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }

        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    /**
     * 随机方向
     */
    private void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    /**
     * 发射子弹
     */
    public void fire() {
        fs.fire(this);
    }

    /**
     * 坦克被击中
     */
    public void die() {
        this.living = false;
    }

    /**
     * 坦克停止
     */
    public void stop() {
        moving = false;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private List<TankFireObserver> fireObservers = Arrays.asList(new TankFireHandler());
    public void handleFireKey() {
        TankFireEvent event = new TankFireEvent(this);
        for (TankFireObserver o : fireObservers) {
            o.actionOnFire(event);
        }
    }
}
