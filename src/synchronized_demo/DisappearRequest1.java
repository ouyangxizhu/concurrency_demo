package synchronized_demo;


/**
 * Created by ouyangxizhu on 2019/5/15.
 * 消失的请求
 */
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();
    static int i = 0;
    public static void main(String[] args){
        try {
            Thread t1 = new Thread(instance);
            Thread t2 = new Thread(instance);
            t1.start();
            t2.start();
            t1.join();
            t2.join();//join方法保证该线程的方法执行完之后才能执行下面的代码。
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        for(int j = 0; j < 100000; j++)
            i++;

    }
}
