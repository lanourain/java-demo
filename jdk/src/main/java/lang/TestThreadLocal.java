package lang;

import java.util.ArrayList;
import java.util.List;

/**
 * 各个线程的value值是相互独立的，本线程的累加操作不会影响到其他线程的值，线程之间的ThreadLocal数据相互隔离
 */
public class TestThreadLocal {
    private static ThreadLocal<Integer> value_1 = ThreadLocal.withInitial(() -> 0);
    private static ThreadLocal<Integer> value_2 = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            Thread t = new Thread(new MyThread(i));
            t.start();
            list.add(t);
        }
        System.out.println(list.size());
    }

    static class MyThread implements Runnable {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("线程" + index + "的初始value_1:" + value_1.get());
            System.out.println("线程" + index + "的初始value_2:" + value_2.get());
            for (int i = 1; i <= 10; i++) {
                value_1.set(value_1.get() + i);
                value_2.set(value_2.get() * i);
            }
            System.gc();
            System.out.println("线程" + index + "的累加value_1:" + value_1.get());
            System.out.println("线程" + index + "的累加value_2:" + value_2.get());
        }
    }
}
