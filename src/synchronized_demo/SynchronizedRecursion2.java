package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 粒度证明    证明可重入不要求是同一个方法   调用类内另外的方法
 */
public class SynchronizedRecursion2 {

    public synchronized void method1() {
        System.out.println("我是method1" );
        method2();
    }
    public synchronized void method2() {
        System.out.println("我是method2" );
    }

    public static void main(String[] args) {
        SynchronizedRecursion2 synchronizedRecursion1 = new SynchronizedRecursion2();
        synchronizedRecursion1.method1();
        System.out.println("finished");
    }
}
