package Concurrency;

import java.util.concurrent.Semaphore;

/**
 * 使用Semaphore限制操作数
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        int nThreads = 10;
        Semaphore sem = new Semaphore(nThreads / 2);

        for (int i = 0; i < nThreads; i++) {
            final int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    System.out.println("Thread " + finalI + " 尝试获取资源！");
                    // 同时只能有5个线程获取到许可，别的5个线程要等别的释放掉之后才能获取
                    sem.acquire();
                    System.out.println("Thread " + finalI + " 获取资源!");
                    Thread.sleep(5000);
                    sem.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            t.start();
        }
    }
}
