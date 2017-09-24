package singleton;

// 饿汉式，线程安全
class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }

    static Singleton1 getInstance() {
        return singleton;
    }
}

// 懒汉式，线程不安全
class Singleton2 {
    private static Singleton2 singleton;

    private Singleton2() {
    }

    static Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }

//    static synchronized Singleton2 getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton2();
//        }
//        return singleton;
//    }
}

// 双重检验锁
class Singleton3 {
    private volatile static Singleton3 singleton;

    private Singleton3() {
    }

    static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}

public class SingletonExample {
    public static void main(String[] args) {


        // 线程安全测试
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Singleton2.getInstance().hashCode());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }).start();
        }

        Singleton1 a = Singleton1.getInstance();
        Singleton1 b = Singleton1.getInstance();
        Singleton2 c = Singleton2.getInstance();
        Singleton2 d = Singleton2.getInstance();
        Singleton3 e = Singleton3.getInstance();
        Singleton3 f = Singleton3.getInstance();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(e.hashCode());
        System.out.println(f.hashCode());

    }
}
