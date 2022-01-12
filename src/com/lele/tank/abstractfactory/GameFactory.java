package com.lele.tank.abstractfactory;

import com.lele.tank.Dir;
import com.lele.tank.Group;
import com.lele.tank.Tank;
import com.lele.tank.TankFrame;

/**
 * @author: lele
 * @date: 2022/1/11 7:45
 * @description:
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

}
