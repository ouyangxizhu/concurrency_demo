package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 对象锁实例，普通方法锁
 */
public class SynchronizedObjectMethod2 implements Runnable{
    static SynchronizedObjectMethod2 instance = new SynchronizedObjectMethod2();
    @Override
    public void run() {
        method();

    }
    public synchronized void method(){
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
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
