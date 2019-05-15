package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 *  两个线程访问synchronized的静态方法
 */
public class SynchronizedStyle3 implements Runnable {
    static SynchronizedStyle3 instance1 = new SynchronizedStyle3();
    static SynchronizedStyle3 instance2 = new SynchronizedStyle3();

    @Override
    public void run() {
        method();

    }
    public static synchronized void method(){
        System.out.println("我是两个线程访问synchronized的静态方法形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) ;//空循环
        System.out.println("finished");
    }
}
