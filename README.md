## tank
> 坦克大战

### 1.游戏说明
1. 键盘上下左右控制坦克的移动
2. Ctrl发射子弹

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
- 加入声音