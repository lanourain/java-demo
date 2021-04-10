package multithread.threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceShutDownNow {

    public static void main(String[] args) {
        // 线程池中5个线程
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 创建10个任务扔进线程池进行处理
        for (int i = 0; i < 10; i++) {
            executor.execute(new WorkerThread("" + i));
        }
        // 立刻关闭，关闭当前在执行的任务，并返回未开始执行的任务
        List<Runnable> runnables = executor.shutdownNow();
        for (Runnable runnable : runnables) {
            System.out.println(runnable.toString());
        }
        System.out.println("Finished all threads");
    }
}
