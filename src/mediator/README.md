# 中介者模式

用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

实例：

- 机场调度系统
- MVC 框架，其中C（控制器）就是 M（模型）和 V（视图）的中介者

优点： 
- 降低了类的复杂度，将一对多转化成了一对一 
- 各个类之间的解耦
- 符合[迪米特原则](https://baike.baidu.com/item/%E8%BF%AA%E7%B1%B3%E7%89%B9%E6%B3%95%E5%88%99/2107000)