package synchronized_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ouyangxizhu on 2019/5/15.
 */
public class SynchcronizedToLock {
    Lock lock = new ReentrantLock();
    public synchronized void method1(){
        System.out.println("我是synchronized形式的锁");
    }
    public void method2(){
        try {
            lock.lock();
            System.out.println("我是Lock形式的锁");
        } finally {
            lock.unlock();
        }

    }
    public static void main(String[] args){
        SynchcronizedToLock s = new SynchcronizedToLock();
        s.method1();
        s.method2();
    }
}
