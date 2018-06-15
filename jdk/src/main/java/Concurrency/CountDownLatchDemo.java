package Concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch统筹线程之间的执行
 * 创建N个线程，创建完后一起执行，等都执行完之后执行下一步操作
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        int nThreads = 10;
        // 控制等所有线程都创建完成后再一起执行
        CountDownLatch startGate = new CountDownLatch(1);
        // 控制等所有线程都执行完毕后执行别的操作
        CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            final int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        Runnable task = () -> {
                            System.out.println("Thread " + finalI + " begin!");
                            try {
                                Thread.sleep(finalI * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Thread " + finalI + " end!");
                        };
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {
                }
            });
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
