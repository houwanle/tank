package com.lele.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: lele
 * @date: 2021/12/28 7:42
 * @description: 继承Frame，重写其中的方法
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Dir.DOWN);

    public TankFrame(){
        // 设置窗口大小
        setSize(800, 600); // 像素
        // 设置窗口是否可以改变大小
        setResizable(false);
        // 设置窗口的标题
        setTitle("tank war");
        // 显示窗口
        setVisible(true);

        // 窗口事件监听
        this.addKeyListener(new MyKeyListener());

        // 添加Window的监听器
        addWindowListener(new WindowAdapter() {

            // 关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        // 画坦克
        myTank.paint(g);

    }

    /**
     * 键盘监听处理类
     */
    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        /**
         * 键 被按下去的时候，调用该方法
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            // 获取按键代码
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT: // 向左按键
                    bL = true;
                    break;
                case KeyEvent.VK_UP: // 向上按键
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT: // 向右按键
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN: // 向下按键
                    bD = true;
                    break;
                default:
                    break;
            }

            // 设置主战坦克的方向
            setMainTankDir();
        }

        /**
         * 设置主战坦克的方向
         */
        private void setMainTankDir() {
            if (bL) {
                myTank.setDir(Dir.LEFT);
            }
            if (bU) {
                myTank.setDir(Dir.UP);
            }
            if (bR) {
                myTank.setDir(Dir.RIGHT);
            }
            if (bD) {
                myTank.setDir(Dir.DOWN);
            }
        }

        /**
         * 键 被弹起来的时候调用该方法
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
            // 获取按键代码
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT: // 向左按键
                    bL = false;
                    break;
                case KeyEvent.VK_UP: // 向上按键
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT: // 向右按键
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN: // 向下按键
                    bD = false;
                    break;
                default:
                    break;
            }

            // 设置主战坦克的方向
            setMainTankDir();
        }
    }
}
