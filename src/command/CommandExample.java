package command;

// 命令抽象类，对外公布execute方法
abstract class Command {
    public abstract void execute();
}

// 命令实现类
class ConcreteCommand extends Command {
    private Receiver receiver;

    ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.doSomething();
    }
}

// 调用者，调用命令
class Invoker {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void exec() {
        this.command.execute();
    }
}

// 接收者，接收和执行命令
class Receiver {
    void doSomething() {
        System.out.println("接受者-业务逻辑处理");
    }
}

public class CommandExample {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        // 客户端直接执行具体命令方式
        // command.execute();

        // 客户端通过调用者来执行命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.exec();
    }
}
