package multithread.synchronizedDemo;

/**
 * 同步线程
 */
public class SyncThreadLockClass implements Runnable {
    private static int count;

    public SyncThreadLockClass() {
        count = 0;
    }

    public void run() {
        // synchronized对类加锁，作用与所有对象
        synchronized (SyncThreadLockClass.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}
