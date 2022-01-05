package com.lele.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author: lele
 * @date: 2022/1/5 7:53
 * @description: 图片处理类
 */
public class ImageUtil {

    /**
     * 图片旋转：
     * @param bufferedImage 图片
     * @param degree 旋转度数，负数为逆时针
     * @return
     */
    public static BufferedImage rotateImage(final BufferedImage bufferedImage,
                                            final int degree) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int type = bufferedImage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedImage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }
}
