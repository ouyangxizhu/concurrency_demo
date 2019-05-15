package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 反编译字节码
 */
public class SynchronizedDecompilation {
    private Object object = new Object();
    public void insert(Thread thread){
        synchronized (object){

        }
    }
}
