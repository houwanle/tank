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

    int x = 200, y = 200;

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
        // 填充一个矩形
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;
    }

    /**
     * 键盘监听处理类
     */
    class MyKeyListener extends KeyAdapter {

        /**
         * 键 被按下去的时候，调用该方法
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
        }

        /**
         * 键 被弹起来的时候调用该方法
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
