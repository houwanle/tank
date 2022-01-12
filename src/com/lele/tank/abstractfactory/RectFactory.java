package com.lele.tank.abstractfactory;

import com.lele.tank.Dir;
import com.lele.tank.Group;
import com.lele.tank.TankFrame;

/**
 * @author: lele
 * @date: 2022/1/12 7:37
 * @description:
 */
public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
//        return new RectTank(x, y, dir, group, tf);
        return null;
    }


    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }
}
