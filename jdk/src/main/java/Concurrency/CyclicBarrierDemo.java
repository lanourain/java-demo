package Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用栅栏CyclicBarrier协调多线程
 * 在所有线程都达到一个状态时，去执行下一步操作
 * CountDownLatch用于等待事件，CyclicBarrier用于等待线程
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int nThreads = 10;
        CyclicBarrier barrier = new CyclicBarrier(nThreads, () -> System.out.println("所有线程执行完毕"));

        for (int i = 0; i < nThreads; i++) {
            final int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(finalI * 1000);
                    System.out.println("线程 " + finalI + "执行完毕，进入等待状态");
                    // 线程进入等待状态，等所有线程都执行完毕了，才一起去进行下一步操作
                    barrier.await();
                    System.out.println("线程 " + finalI + "退出");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }

}
