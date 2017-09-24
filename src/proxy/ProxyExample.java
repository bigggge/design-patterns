package proxy;

interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

// ProxyImage 是一个代理类，减少 RealImage 对象加载的内存占用
class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //图像从磁盘加载
        image.display();
        System.out.println("");
        //图像不从磁盘加载
        image.display();
    }
}

