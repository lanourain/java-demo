package multithread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 使用管道输出流PipedOutputStream pos和管道输入流PipedInputStream pis
 * 实现生产者和消费者模式
 * 线程间通信。
 * 管道流只能在两个线程之间传递数据
 * 管道流只能实现单向发送，如果要两个线程之间互通讯，则需要两个管道流
 */
public class PipeConnectionTest {

    public static void main(String[] args) {
        /**
         * 创建管道输出流
         */
        PipedOutputStream pos = new PipedOutputStream();
        /**
         * 创建管道输入流
         */
        PipedInputStream pis = new PipedInputStream();
        try {
            /**
             * 将管道输入流与输出流连接 此过程也可通过重载的构造函数来实现
             */
            pos.connect(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * 创建生产者线程
         */
        Producer p = new Producer(pos);
        /**
         * 创建消费者线程
         */
        Consumer c1 = new Consumer(pis);
        /**
         * 启动线程
         */
        p.start();
        c1.start();
    }

    /**
     * 生产者线程(与一个管道输入流相关联)
     */
    static class Producer extends Thread {
        private PipedOutputStream pos;

        public Producer(PipedOutputStream pos) {
            this.pos = pos;
        }

        public void run() {
            int i = 0;
            try {
                while (true) {
                    this.sleep(100);
                    System.out.println("Producer:" + i);
                    pos.write(i);
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者线程(与一个管道输入流相关联)
     */
    static class Consumer extends Thread {
        private PipedInputStream pis;

        public Consumer(PipedInputStream pis) {
            this.pis = pis;
        }

        public void run() {
            try {
                while (true) {
                    System.out.println("Consumer:" + pis.read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}