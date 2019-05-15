package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 方法抛出异常后会释放锁
 * 一旦第一个线程抛出异常，第二个线程会立刻获得锁
 */
public class SynchronizedStyle7 implements Runnable {
    static SynchronizedStyle7 instance = new SynchronizedStyle7();


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0"))
            method1();
        else
            method2();

    }
    public synchronized void method1(){
        System.out.println("我是非静态加锁method1，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();

    }
    public synchronized void method2(){
        System.out.println("我是非静态加锁method2，我叫" + Thread.currentThread().getName());
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
