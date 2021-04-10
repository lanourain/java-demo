package multithread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSubmitDemo {

    public static void main(String[] args) {
        // 线程池中5个线程
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<?>> futures = new ArrayList<>();
        // 创建10个任务扔进线程池进行处理
        for (int i = 0; i < 10; i++) {
            // submit可以返回future，用于获取任务的执行结果或取消任务
            futures.add(executor.submit(new WorkerThread("" + i)));
        }
        for (Future<?> future : futures) {
            // 抛出InterruptedException异常，如果线程是sleep等状态
            future.cancel(true);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }
}
