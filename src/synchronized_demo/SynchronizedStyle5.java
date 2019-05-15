package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 访问同一个对象的不同的普通同步方法
 */
public class SynchronizedStyle5 implements Runnable {
    static SynchronizedStyle5 instance = new SynchronizedStyle5();


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0"))
            method1();
        else
            method2();

    }
    public synchronized void method1(){
        System.out.println("我是加锁形式，是method1，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
    public synchronized void method2(){
        System.out.println("我是加锁形式，是method2，我叫" + Thread.currentThread().getName());
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
