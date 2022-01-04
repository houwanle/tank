package com.lele.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 * @author: lele
 * @date: 2022/1/3 9:29
 * @description: 资源管理类
 */
public class ResourceMgr {

    // 坦克图片
    public static BufferedImage tankL, tankU, tankR, tankD;
    // 子弹图片
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    // 爆炸图片
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            // 加载坦克图片
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

            // 加载子弹图片
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

            // 加载爆炸图片
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(
                        ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+ (i+1) +".gif")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
