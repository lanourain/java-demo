import java.util.concurrent.TimeUnit;

/**
 * JVM 关闭时触发，触发场景：
 * 1. 程序正常退出
 * 2. 使用System.exit()
 * 3. 终端使用Ctrl+C触发的中断
 * 4. 系统关闭
 * 5. OutOfMemory宕机
 * 6. 使用Kill pid命令干掉进程（注：在使用kill -9 pid时，是不会被调用的）
 *
 * 如下测试第一种情况...
 */

public class HookTest {

    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Execute Hook.....");
            }
        }));
    }

    public static void main(String[] args) {
        new HookTest().start();
        System.out.println("The Application is doing something");

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
