## tank
> 坦克大战

### 1.游戏说明
1. 键盘上下左右控制坦克的移动
2. Ctrl发射子弹
3. S键保存游戏进度，L键打开保存的记录

### 2.开发环境
- JDK1.8


### 3.开发步骤
- 创建新的窗口 TankFrame
- 创建坦克
  - 定义主战坦克的方向
  - 根据按键改变主战坦克方向
  - 根据方向进行坦克的移动
  - 创建更多的坦克（将坦克封装成类）
- 用双缓冲解决闪烁问题
  - repaint方法会调用update方法
  - 截获update
  - 首先把该画出来的东西（坦克，子弹）先画在内存的图片中，图片大小和游戏画面一致；
  - 把内存中的图片一次性画到屏幕上；（内存的内容复制到显存）
- 创建子弹类
  - 打出一颗子弹（按Ctrl键，主战坦克打出一颗子弹）
  - 打出多颗子弹（将子弹放在容器中）
  - 内存泄漏（创建后的子弹，若不处理，会一直占用内存）
- 将坦克换成图片
  - classloader
  - 显示图片，使用ImageIO
- 将子弹换成图片
- 将子弹从坦克中心位置打出
  - 根据坦克图片的大小，和左上角的位置计算子弹左上角的位置
- 放入敌军坦克
  - 分拨儿 Group
- 子弹与敌军坦克的碰撞检测
  - 击毁一辆坦克
- 加入多辆敌军坦克
- 让敌军坦克动起来
- 加入爆炸
  - 加入到list中
  - 显示数量
- 加入声音
- 敌人坦克简单智能化
  - 随机移动位置
  - 随机发射子弹
- 边界检测
- 解决new Rectangle 问题（MileStone）
- Code Review and Refactor
- 配置文件  
-------------------会有两个分支：设计模式（DesignPattern）、网络版（Network）----------------------
- PropertyMgr的单例问题
- 单例：PropertyMgr  ResourceMgr
  - 单例模式
    - 只需要一个实例（比如各种Mgr、比如各种Factory）
- 策略：Strategy
  - Comparable
  - Comparator
  - 策略模式应用到Tank.fire
  - 通过配置文件配置不同的开火策略，实现敌我双方的不同开火策略
- 装饰器模式（IO流中用到了该模式）
- Observer（观察者模式）
  - 坦克开火事件
- memento 与序列化（S键保存，L键打开保存的记录）
  - 游戏存盘