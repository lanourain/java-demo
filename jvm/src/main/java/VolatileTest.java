/**
 * volatile定义的变量有如下属性：
 * 1. 保证此变量对所有线程可见（只保证可见性，不保证操作结果一致）
 */

public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        // 虽然volatile保证所有线程可见，但是由于race++ 这个操作并不是原子性的，所以还是会有并发的问题。
        // 基于volatile变量的操作存在一致性的问题
        // 每个线程操作race前，工作线程的数据都是一致的，但是后续++操作回写回去后，会导致并发问题

        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        // 等所有累加线程结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        // 结果不是 200000，比该值小
        System.out.println(race);
    }
}
