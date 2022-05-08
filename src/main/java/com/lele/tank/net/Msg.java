package com.lele.tank.net;

/**
 * @author: lele
 * @date: 2022/4/10 19:33
 * @description:
 */
public abstract class Msg {

    public abstract void handle();
    public abstract byte[] toBytes();
    public abstract void parse(byte[] bytes);
    public abstract MsgType getMsgType();
}
