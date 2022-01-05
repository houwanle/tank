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
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);
            tankD = ImageUtil.rotateImage(tankU, 180);

            // 加载子弹图片
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);

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
