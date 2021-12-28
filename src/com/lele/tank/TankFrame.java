package com.lele.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: lele
 * @date: 2021/12/28 7:42
 * @description: 继承Frame，重写其中的方法
 */
public class TankFrame extends Frame {

    public TankFrame(){
        // 设置窗口大小
        setSize(800, 600); // 像素
        // 设置窗口是否可以改变大小
        setResizable(false);
        // 设置窗口的标题
        setTitle("tank war");
        // 显示窗口
        setVisible(true);

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
        g.fillRect(200, 200, 50, 50);
    }
}
