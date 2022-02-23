package com.lele.tank;

import com.lele.tank.cor.BulletTankCollider;
import com.lele.tank.cor.Collider;
import com.lele.tank.cor.ColliderChain;
import com.lele.tank.cor.TankTankCollider;

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

//    List<Bullet> bullets = new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();

    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount").toString());

        // 初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    /**
     * 添加
     * @param go
     */
    public void add(GameObject go) {
        this.objects.add(go);
    }

    /**
     * 删除
     * @param go
     */
    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量" + bullets.size(), 10, 60);
//        g.drawString("敌人的数量" + tanks.size(), 10, 80);
//        g.drawString("爆炸的数量" + explodes.size(), 10, 100);
        g.setColor(c);

        // 画坦克
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        // 互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                //for
                chain.collide(o1, o2);
            }
        }

//        // 碰撞检测
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}