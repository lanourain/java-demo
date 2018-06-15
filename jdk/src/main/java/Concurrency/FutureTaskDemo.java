package Concurrency;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask执行异步任务
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask future = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return new Date();
            }
        });

        Thread t = new Thread(future);
        t.start();
        System.out.println(new Date());
        System.out.println(future.get());
    }
}
