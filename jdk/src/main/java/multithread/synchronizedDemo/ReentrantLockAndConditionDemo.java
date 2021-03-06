package multithread.synchronizedDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock上附加Condition使用。
 */
public class ReentrantLockAndConditionDemo {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        // 锁对应的条件变量
        final Condition condition = reentrantLock.newCondition();

        Thread thread1 = new Thread((Runnable) () -> {
            try {
                reentrantLock.lock();
                System.out.println("waitThread1 我要等一个新信号");
                // 以原子方式暂时释放锁，并挂起当前线程，等待唤醒信号
                // 等待到唤醒信号后，会重新去获取锁，如果未获取到锁，则会一直等待
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("waitThread1 拿到一个信号！！");
            reentrantLock.unlock();
        }, "waitThread1");

        thread1.start();

        Thread thread2 = new Thread((Runnable) () -> {
            reentrantLock.lock();
            System.out.println("signalThread 我拿到锁了");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 发出唤醒信号，同时如果持有锁需要释放锁。
            condition.signalAll();
            System.out.println("signalThread 我发了一个信号！！");
            reentrantLock.unlock();
            System.out.println("signalThread 我释放锁了！");
        }, "signalThread");

        thread2.start();
    }
}
