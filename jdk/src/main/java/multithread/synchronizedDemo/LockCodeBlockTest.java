package multithread.synchronizedDemo;

import org.junit.Test;

public class LockCodeBlockTest {

    @Test
    /**
     * thread1 和 thread2 访问同一个对象的synchronized代码块，执行互斥。
     * 同一时刻只能有一个线程得到执行。
     */
    public void test_1() throws InterruptedException {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
    }

    @Test
    /**
     * 两个线程持有不同对象的锁，不互斥，可以同时执行。
     */
    public void test_2() throws InterruptedException {
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
    }

    @Test
    /**
     * 同一个对象，一个线程访问synchronized区域时，别的线程可以访问非synchronized区域
     */
    public void test_3() throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter, "A");
        Thread thread2 = new Thread(counter, "B");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
    }

    @Test
    /**
     * 因为进入synchronized区域表示获取对象的锁，所以不同线程不能同时访问同一个对象的不同synchronized区域。
     * 一个对象只有一个锁，进入synchronized表示获取锁，只能被一个线程持有。
     */
    public void test_4() throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter, "A");
        Thread thread2 = new Thread(counter, "C");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
    }
}
