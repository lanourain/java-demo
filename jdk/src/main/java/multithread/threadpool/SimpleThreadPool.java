package multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池使用demo
 */
public class SimpleThreadPool {

    public static void main(String[] args) {
        // 线程池中5个线程
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 创建10个任务扔进线程池进行处理
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}