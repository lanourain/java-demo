package multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池使用demo
 */
public class ExecutorExecuteDemo {

    public static void main(String[] args) {
        // 线程池中5个线程
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 创建10个任务扔进线程池进行处理
        for (int i = 0; i < 10; i++) {
            executor.execute(new WorkerThread("" + i));
        }
        //正常关闭，等所有任务执行完成后关闭
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}