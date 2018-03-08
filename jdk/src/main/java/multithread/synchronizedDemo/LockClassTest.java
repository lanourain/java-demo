package multithread.synchronizedDemo;

import org.junit.Test;

public class LockClassTest {

    @Test
    /**
     * synchronized作用于类，所有对象都共享一个锁，不同对象之间也需要争用阻塞
     */
    public void test_2() throws InterruptedException {
        Thread thread1 = new Thread(new SyncThreadLockClass(), "SyncThreadLockClass1");
        Thread thread2 = new Thread(new SyncThreadLockClass(), "SyncThreadLockClass2");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
    }
}
