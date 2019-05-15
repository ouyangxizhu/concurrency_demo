package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 两个线程同时访问一个对象的同步方法
 */
public class SynchronizedStyle1 implements Runnable{
    static SynchronizedStyle1 instance = new SynchronizedStyle1();
    @Override
    public void run() {
        method();

    }
    public synchronized void method(){
        System.out.println("我是两个线程同时访问一个对象的同步方法形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive());//空循环
        System.out.println("finished");
    }
}
