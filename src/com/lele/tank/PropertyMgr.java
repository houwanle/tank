package com.lele.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: lele
 * @date: 2022/1/7 7:29
 * @description: 配置文件管理类
 */
public class PropertyMgr {

    static Properties props = new Properties();

    static {
        try {
            // 加载config配置文件
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) {
            return null;
        }

        return props.get(key);
    }

    // int getInt
    //getString(key)

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
