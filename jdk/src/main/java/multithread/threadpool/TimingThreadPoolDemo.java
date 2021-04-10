package multithread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

// FIXME 好像并没有生效啊？？？？
public class TimingThreadPoolDemo {

    public static void main(String[] args) {
        TimingThreadPool timeingThreadPool = new TimingThreadPool(5, 5, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        // 创建10个任务扔进线程池进行处理
        for (int i = 0; i < 10; i++) {
            timeingThreadPool.execute(new WorkerThread("" + i));
        }
        //正常关闭，等所有任务执行完成后关闭
        timeingThreadPool.shutdown();
        while (!timeingThreadPool.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }


    //增加了日志和计时功能的线程池
    public static class TimingThreadPool extends ThreadPoolExecutor {

        private final ThreadLocal<Long> startTime = new ThreadLocal<>();

        private final Logger log = Logger.getLogger("TimingThreadPool");

        private final AtomicLong numTasks = new AtomicLong();

        private final AtomicLong totalTime = new AtomicLong();

        public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                TimeUnit unit,
                BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
            log.fine(String.format("Thread %s: start %s", t, r));
            startTime.set(System.nanoTime());
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            try {
                long endTime = System.nanoTime();
                long taskTime = endTime - startTime.get();
                numTasks.addAndGet(taskTime);
                log.fine(String.format("Thread %s: end %s, time=%dns", t, r, taskTime));
            } finally {
                super.afterExecute(r, t);
            }
        }

        @Override
        protected void terminated() {
            try {
                log.info(String.format("Terminated: avg time = %dns", totalTime.get() / numTasks
                        .get()));
            } finally {
                super.terminated();
            }
        }
    }

}
