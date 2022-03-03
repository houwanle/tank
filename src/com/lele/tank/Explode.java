package com.lele.tank;

import java.awt.*;

/**
 * @author: lele
 * @date: 2022/1/2 15:12
 * @description: 爆炸类
 */
public class Explode extends GameObject {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth(); // 爆炸图片的宽度
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight(); //爆炸图片的高度

    private int x, y; // 位置

//    private boolean living = true; // 子弹是否有效

    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(()-> new Audio("audio/explode.wav").play()).start();
        GameModel.getInstance().add(this);
    }

    /**
     * 画
     * @param g
     */
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length) {
            GameModel.getInstance().remove(this);
        }
    }

}
