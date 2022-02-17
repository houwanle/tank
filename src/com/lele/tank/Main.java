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

        new Thread(() -> new Audio("audio/war1.wav").loop()).start();

        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
