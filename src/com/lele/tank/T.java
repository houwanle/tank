package com.lele.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: lele
 * @date: 2021/12/27 7:22
 * @description:
 */
public class T {

    public static void main(String[] args) {
        // 窗口
        Frame f = new Frame();
        // 设置窗口大小
        f.setSize(800, 600); // 像素
        // 设置窗口是否可以改变大小
        f.setResizable(false);
        // 设置窗口的标题
        f.setTitle("tank war");
        // 显示窗口
        f.setVisible(true);

        // 添加Window的监听器
        f.addWindowListener(new WindowAdapter() {

            // 关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
