package multithread.synchronizedDemo;

public class SyncThreadLockMethod implements Runnable {
    private static int count;

    public SyncThreadLockMethod() {
        count = 0;
    }

    // synchronized修改方法，效果和在方法内把方法体都包起来一样。
    // synchronized关键字不能被继承
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count;
    }
}
