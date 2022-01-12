package com.lele.tank.abstractfactory;

import com.lele.tank.Audio;
import com.lele.tank.ResourceMgr;
import com.lele.tank.TankFrame;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/12 7:36
 * @description: 方的爆炸
 */
public class RectExplode extends BaseExplode {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth(); // 爆炸图片的宽度
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight(); //爆炸图片的高度

    private int x, y; // 位置

    //    private boolean living = true; // 子弹是否有效
    private TankFrame tf = null;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    /**
     * 画
     * @param g
     */
    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;

        if (step >= 15) {
            tf.explodes.remove(this);
        }

        g.setColor(c);
    }
}
