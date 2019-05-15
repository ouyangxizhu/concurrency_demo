package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 对象锁 代码块形式
 */
public class SynchronizedObjectCodeBlock3 implements Runnable{
    static SynchronizedObjectCodeBlock3 instance = new SynchronizedObjectCodeBlock3();
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式，我是：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行完毕");
        }

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
