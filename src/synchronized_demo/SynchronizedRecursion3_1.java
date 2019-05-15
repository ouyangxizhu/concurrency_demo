package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 粒度证明    证明可重入不要求是同一个类中的
 */
public class SynchronizedRecursion3_1 {
    static TestSyn t = new TestSyn();
    public static void method(){
        synchronized(t.getClass()){
            System.out.println("我是SynchronizedRecursion3_1的method方法");
        }
    }
}
class TestSyn{
    public static void main(String[] args){
        method();
    }
    public synchronized static void method(){
        System.out.println("我是TestSyn的method方法");
        SynchronizedRecursion3_1.method();
    }
    
}
