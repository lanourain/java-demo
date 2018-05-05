package multithread.createThread;

// 使用 Thread类创建线程
public class Example1 {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        myThread.start();
        while (true) {
            System.out.println("Main方法在运行");
        }
    }
}

class MyThread1 extends Thread {
    public void run() {
        while (true) {
            System.out.println("MyThread类的run()方法在运行");
        }
    }
}