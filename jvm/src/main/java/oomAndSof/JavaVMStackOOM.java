package oomAndSof;

/**
 * -Xss2M
 * 创建线程导致OOM
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 * 电脑会卡...轻易别跑...
 */

public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread t = new Thread(() -> dontStop());
            t.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
