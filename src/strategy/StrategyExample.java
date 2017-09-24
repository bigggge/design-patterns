package strategy;

interface IStrategy {
    void doSomething();
}

class ConcreteStrategy1 implements IStrategy {
    public void doSomething() {
        System.out.println("策略1");
    }
}

class ConcreteStrategy2 implements IStrategy {
    public void doSomething() {
        System.out.println("策略2");
    }
}

class Context {
    private IStrategy strategy;

    Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    void execute() {
        strategy.doSomething();
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrategy1());
        context.execute();

        context = new Context(new ConcreteStrategy2());
        context.execute();
    }
}