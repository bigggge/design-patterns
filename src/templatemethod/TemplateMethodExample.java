package templatemethod;

abstract class AbstractSort {

    protected abstract void sort(int[] array);

    void show(int[] array) {
        this.sort(array);
        System.out.print("排序结果：");
        for (int item : array) {
            System.out.printf(" " + item);
        }
    }
}

class SelectionSort extends AbstractSort {
    @Override
    protected void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if ((array[j] < array[min])) min = j;
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}

public class TemplateMethodExample {

    public static int[] a = {10, 32, 1, 9, 5, 7, 12, 0}; // 预设数据数组

    public static void main(String[] args) {
        AbstractSort s = new SelectionSort();
        s.show(a);
    }
}
