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

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
