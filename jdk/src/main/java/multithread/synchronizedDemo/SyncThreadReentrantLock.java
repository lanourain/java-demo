package multithread.synchronizedDemo;

import java.util.concurrent.locks.ReentrantLock;

public class SyncThreadReentrantLock implements Runnable {
    private static int count;

    private static ReentrantLock lock;

    public SyncThreadReentrantLock(ReentrantLock lock) {
        count = 0;
        this.lock = lock;
    }

    public void run() {
        // 使用 ReentrantLock实现和synchronized锁代码块一样的效果
        lock.lock();
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

    public int getCount() {
        return count;
    }
}
