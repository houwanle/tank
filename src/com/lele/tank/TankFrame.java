package com.lele.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: lele
 * @date: 2021/12/28 7:42
 * @description: 继承Frame，重写其中的方法
 */
public class TankFrame extends Frame {

    GameModel gm = new GameModel();

    static final int GAME_WIDTH = 800; //游戏窗口宽度
    static final int GAME_HEIGHT = 600; // 游戏窗口高度

    public TankFrame(){
        // 设置窗口大小
        setSize(GAME_WIDTH, GAME_HEIGHT); // 像素
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

    Image offScreenImage = null;

    /**
     * 用双缓冲解决闪烁问题
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        gm.paint(g);

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
         * 键 被弹起来的时候调用该方法
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
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
                case KeyEvent.VK_CONTROL: // Ctrl键
                    gm.getMainTank().fire(); // 打出一颗子弹
                    break;
                default:
                    break;
            }

            // 设置主战坦克的方向
            setMainTankDir();

//            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
        }

        /**
         * 设置主战坦克的方向
         */
        private void setMainTankDir() {
            Tank myTank = gm.getMainTank();

            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true); //坦克开始移动

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
        }
    }
}
