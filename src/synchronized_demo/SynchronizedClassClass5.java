package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 类锁 synchronized(*.class)形式
 */
public class SynchronizedClassClass5 implements Runnable {
    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    @Override
    public void run() {
        method();

    }
    public synchronized void method(){
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("我是对象锁的synchronized(*.class)形式，我是：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行完毕");
        }
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
