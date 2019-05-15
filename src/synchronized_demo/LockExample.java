package synchronized_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ouyangxizhu on 2019/5/15.
 */
public class LockExample {
    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        lock.lock();//锁住
        lock.unlock();//释放
        boolean b1 = lock.tryLock();//可以知道是否可以获得锁
        try {
            boolean b2 = lock.tryLock(3000, TimeUnit.SECONDS);//可以设置超时时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();//读写锁
        reentrantReadWriteLock.readLock();//读锁
        reentrantReadWriteLock.writeLock();//写锁

    }
}
