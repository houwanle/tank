package com.lele.tank;

/**
 * @author: lele
 * @date: 2021/12/27 7:22
 * @description: 启动类
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 窗口
        TankFrame tf = new TankFrame();

        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount").toString());

        // 初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tf.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, tf));
        }

        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
