package com.lele.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lele
 * @date: 2022/2/16 7:38
 * @description:
 */
public class GameModel {

    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this); //初始化我方坦克

    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount").toString());

        // 初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("敌人的数量" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量" + explodes.size(), 10, 100);
        g.setColor(c);

        // 画坦克
        myTank.paint(g);

        // 画子弹
//        for (Bullet b : bullets) { //用此种方法画子弹，在删除子弹的时候会报java.util.ConcurrentModificationException错
//            b.paint(g);
//        }
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        // 画坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        // 画爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        // 碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
