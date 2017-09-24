# 观察者模式

观察者模式定义了一个一对多的依赖关系，让一个或多个观察者对象监听一个主题对象。这样一来，当被观察者状态发生改变时，需要通知相应的观察者，使这些观察者对象能够自动更新。

```java
public class ObserverExample {

    public static void main(String[] args) {

        MilkProvider provider = new MilkProvider();

        Consumer consumer1 = new Consumer("道格拉斯");
        Consumer consumer2 = new Consumer("图灵");
        Consumer consumer3 = new Consumer("牛顿");

        provider.addObserver(consumer1);
        provider.addObserver(consumer2);
        provider.addObserver(consumer3);
        provider.deleteObserver(consumer3);

        provider.milkProduced("草莓味的牛奶");
    }

    // 静态成员属于类,不需要生成对象就存在了.
    // 而非静态需要生成对象才产生，所以静态成员不能直接访问.所以声明为静态类

    // 被观察者 牛奶站
    static class MilkProvider extends Observable {

        // 牛奶做好啦
        void milkProduced(String milkType) {
            // 标识状态或内容发生改变
            setChanged();
            // 通知所有订奶的客户（观察者）
            notifyObservers(milkType);
        }
    }

    //观察者 订奶的客户
    static class Consumer implements Observer {

        private String name;

        Consumer(String name) {
            this.name = name;
        }

        @Override
        public void update(Observable observable, Object o) {
            System.out.println("Hi， " + name + " 牛奶做好啦！" + " observable=" + observable + " o=" + o);
        }

        @Override
        public String toString() {
            return "toString " + name;
        }
    }

}
```


# 优点

- 松耦合（被观察者可以增加删除观察者；被观察者只负责通知观察者；观察者只需等待通知；）
- 通知不错过（被动接受，不易错过通知）

# 扩展的观察者模式

RxJava 是一个实现异步操作的库。它有四个基本概念：Observable (可观察者，即被观察者)、 Observer (观察者)、 subscribe (订阅)、事件。
Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer。

与传统观察者模式不同， RxJava 的事件回调方法除了普通事件 onNext() （相当于 onClick() / onEvent()）之外，还定义了两个特殊的事件：onCompleted() 和 onError()。

- onCompleted(): 事件队列完结。RxJava 不仅把每个事件单独处理，还会把它们看做一个队列。RxJava 规定，当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志。
- onError(): 事件队列异常。在事件处理过程中出异常时，onError() 会被触发，同时队列自动终止，不允许再有事件发出。
