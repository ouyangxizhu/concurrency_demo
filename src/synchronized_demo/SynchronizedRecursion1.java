package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 粒度证明    证明同一个方法是可重入的（递归调用本身）
 */
public class SynchronizedRecursion1 {
    int a = 0;
    public synchronized void method1() {
        System.out.println("我是method1，a = " + a);
        if (a == 0) {
            a++;
            method1();
        }
    }

    public static void main(String[] args) {
        SynchronizedRecursion1 synchronizedRecursion1 = new SynchronizedRecursion1();
        synchronizedRecursion1.method1();
        System.out.println("finished");
    }
}
