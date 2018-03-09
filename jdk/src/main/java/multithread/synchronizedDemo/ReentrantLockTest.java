package multithread.synchronizedDemo;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ReentrantLockTest {

    @Test
    /**
     * thread1 和 thread2 只能有一个持有 ReentrantLock锁
     * 同一时刻只能有一个线程得到执行。
     */
    public void test_1() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        SyncThreadReentrantLock syncThreadReentrantLock = new SyncThreadReentrantLock(lock);
        Thread thread1 = new Thread(syncThreadReentrantLock, "SyncThread1");
        Thread thread2 = new Thread(syncThreadReentrantLock, "SyncThread2");
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
    }
}
