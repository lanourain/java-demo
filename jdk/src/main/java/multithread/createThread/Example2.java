package multithread.createThread;

// 使用Runnable接口作为Thread的构造参数创建线程。
public class Example2 {

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
        while (true) {
            System.out.println("Main方法在运行");
        }
    }
}

class MyThread2 implements Runnable {
    public void run() {
        while (true) {
            System.out.println("MyThread类的run()方法在运行");
        }
    }
}
