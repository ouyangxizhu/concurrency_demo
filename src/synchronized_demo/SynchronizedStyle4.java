package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 同时访问同步方法和非同步方法
 */
public class SynchronizedStyle4 implements Runnable {
    static SynchronizedStyle4 instance = new SynchronizedStyle4();


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0"))
            method1();
        else
            method2();

    }
    public synchronized void method1(){
        System.out.println("我是加锁形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
    public void method2(){
        System.out.println("我是不加锁形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) ;//空循环
        System.out.println("finished");
    }
}
