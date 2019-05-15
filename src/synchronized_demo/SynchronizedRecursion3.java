package synchronized_demo;

/**
 * Created by ouyangxizhu on 2019/5/15.
 * 粒度证明    证明可重入不要求是同一个类中的   调用父类的方法
 */
public class SynchronizedRecursion3 {

    public synchronized void doSomething() {
        System.out.println("我是父类的方法" );

    }

}
class TestClass extends SynchronizedRecursion3{
    public synchronized void doSomething() {
        System.out.println("我是子类的方法" );
        super.doSomething();
    }
    public static void main(String[] args) {
        TestClass s = new TestClass();
        s.doSomething();
        System.out.println("finished");
    }
}
