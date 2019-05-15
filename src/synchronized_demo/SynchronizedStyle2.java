package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 两个线程访问两个对象的同步方法
 */
public class SynchronizedStyle2 implements Runnable{
    static SynchronizedStyle2 instance1 = new SynchronizedStyle2();
    static SynchronizedStyle2 instance2 = new SynchronizedStyle2();
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是两个线程访问两个对象的同步方法形式，我是：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行完毕");
        }

    }
    public static void main(String[] args){
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive());//空循环
        System.out.println("finished");
    }
}
