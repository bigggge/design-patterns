package composite;


import java.util.ArrayList;

abstract class Component {
    protected String name;

    Component(String name) {
        this.name = name;
    }

    public abstract void doSomething();
}

class Composite extends Component {

    Composite(String name) {
        super(name);
    }

    //构件容器
    private ArrayList<Component> components = new ArrayList<>();

    // 增加一个叶子构件或树枝构件
    void add(Component component) {
        components.add(component);
    }

    // 删除一个叶子构件或树枝构件
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void doSomething() {
        System.out.println(name);
        if (null != components) {
            for (Component c : components) {
                c.doSomething();
            }
        }
    }
}

class Leaf extends Component {

    Leaf(String name) {
        super(name);
    }

    @Override
    public void doSomething() {
        System.out.println(name);
    }
}

public class CompositeExample {
    public static void main(String[] args) {
        //创建一个根节点
        Composite root = new Composite("Root");
        //创建一个树枝构件
        Composite branch1 = new Composite("Branch1");
        Composite branch2 = new Composite("Branch2");
        //创建一个叶子节点
        Leaf leaf1 = new Leaf("Leaf1");
        Leaf leaf2 = new Leaf("Leaf2");
        branch1.add(leaf1);
        branch2.add(leaf2);
        //建立整体
        root.add(branch1);
        root.add(branch2);
        root.add(leaf1);
        root.doSomething();
    }
}
