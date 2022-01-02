package test;


import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;

/**
 * @author: lele
 * @date: 2022/1/2 17:39
 * @description: 测试类
 */
public class ImageTest {

    @Test
    public void test() {

        try {
            BufferedImage image = ImageIO.read(new File("F:\\temp-msb-gitlab\\tank-master\\tank\\src\\images\\bulletD.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
